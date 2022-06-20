import React, {useEffect} from "react";
import {useParams} from "react-router-dom";
import OverallResult from "./OverallResult";
import {useDispatch, useSelector} from "react-redux";
import {
  fetchCompetitionById,
  fetchOverallResultsByCompetitionId,
  fetchStageViewResultsByCompetitionId,
  setViewSwitcherOverall,
  setViewSwitcherStage
} from "../../redux/service/competitionSerivce";
import StagesViewResult from "./StagesViewResult";

export default function CompetitionDetails() {

  const {competitionId} = useParams();
  const {currentCompetition, currentOverallResults, currentStageViewResults, viewSwitcher} = useSelector(
      (store) => store.competitionsReducer)
  const dispatch = useDispatch();

  useEffect(() => {
    if (competitionId) {
      dispatch(fetchCompetitionById(competitionId));
    }
  }, [competitionId])

  useEffect(() => {
    dispatch(fetchOverallResultsByCompetitionId(competitionId));
  }, [])

  useEffect(() => {
    if (viewSwitcher === 'OVERALL') {
      dispatch(fetchOverallResultsByCompetitionId(competitionId));
    } else if (viewSwitcher === 'STAGE') {
      dispatch(fetchStageViewResultsByCompetitionId(competitionId));
    }
  }, [viewSwitcher])

  const onViewSwitcherClick = () => {
    if (viewSwitcher === 'OVERALL') {
      dispatch(setViewSwitcherStage())
    } else {
      dispatch(setViewSwitcherOverall())
    }
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
        <button onClick={onViewSwitcherClick}>{viewSwitcher}</button>
        {viewSwitcher === 'OVERALL'
            ? <OverallResult result={currentOverallResults} competitionId={competitionId}/>
            : <StagesViewResult result={currentStageViewResults} competitionId={competitionId}/>}
      </div>
  )
}
