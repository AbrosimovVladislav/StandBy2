import React, {useEffect} from "react";
import {useParams} from "react-router-dom";
import OverallResult from "./OverallResult";
import {useDispatch, useSelector} from "react-redux";
import {
  fetchCompetitionById,
  fetchCompetitorViewResultsByCompetitionId,
  fetchOverallResultsByCompetitionId,
  fetchStageViewResultsByCompetitionId,
  setViewSwitcherCompetitor,
  setViewSwitcherOverall,
  setViewSwitcherStage
} from "../../redux/service/competitionSerivce";
import StagesViewResult from "./StagesViewResult";
import CompetitorViewResults from "./CompetitorViewResults";

export default function CompetitionDetails() {

  const {competitionId} = useParams();
  const {
    currentCompetition,
    currentOverallResults,
    currentStageViewResults,
    currentCompetitorViewResults,
    viewSwitcher
  } = useSelector((store) => store.competitionsReducer)
  const dispatch = useDispatch();

  useEffect(() => {
    if (competitionId) {
      dispatch(fetchCompetitionById(competitionId));
    }
  }, [competitionId])

  useEffect(() => {
    if (viewSwitcher === 'OVERALL') {
      dispatch(fetchOverallResultsByCompetitionId(competitionId));
    } else if (viewSwitcher === 'STAGE') {
      dispatch(fetchStageViewResultsByCompetitionId(competitionId));
    } else if (viewSwitcher === 'COMPETITOR') {
      dispatch(fetchCompetitorViewResultsByCompetitionId(competitionId));
    }
  }, [viewSwitcher])

  const onOverallClick = () => {
    dispatch(setViewSwitcherOverall())
  }

  const onStageClick = () => {
    dispatch(setViewSwitcherStage())
  }

  const onCompetitorClick = () => {
    dispatch(setViewSwitcherCompetitor())
  }

  return (
      <div>
        <div>
          <h1>Name: {currentCompetition?.competition?.name}</h1>
          <p>Date: {currentCompetition?.competition?.startDate} - {currentCompetition
              && currentCompetition?.competition?.finishDate}</p>
          <p>Level: {currentCompetition?.competition?.level}</p>
          <p>Type: {currentCompetition?.competition?.gunType}</p>
          <p>Place: {currentCompetition?.competition?.place}</p>
          <p>Organizer: {currentCompetition?.competition?.organizer}</p>
        </div>
        <button onClick={onOverallClick}>OVERALL</button>
        <button onClick={onStageClick}>STAGE</button>
        <button onClick={onCompetitorClick}>COMPETITOR</button>
        {viewSwitcher === 'OVERALL'
            ? <OverallResult result={currentOverallResults} competitionId={competitionId}/>
            : viewSwitcher === 'STAGE'
                ? <StagesViewResult result={currentStageViewResults} competitionId={competitionId}/>
                : <CompetitorViewResults result={currentCompetitorViewResults} competitionId={competitionId}/>}
      </div>
  )
}
