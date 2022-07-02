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
          <h1>{currentCompetition?.name}</h1>
          <p>Дата: 29.07.2022 - 30.07.2022</p>
          <p>Уровень: {currentCompetition?.level}</p>
          <p>Класс: {currentCompetition?.gunType}</p>
          <p>Место: {currentCompetition?.place}</p>
          <p>Организатор: {currentCompetition?.organizer}</p>
        </div>
        <h2>Результаты</h2>
        <button onClick={onOverallClick}>OVERALL</button>
        <button onClick={onStageClick}>BY STAGE</button>
        <button onClick={onCompetitorClick}>BY COMPETITOR</button>
        {viewSwitcher === 'OVERALL'
            ? <OverallResult result={currentOverallResults} competitionId={competitionId}/>
            : viewSwitcher === 'STAGE'
                ? <StagesViewResult result={currentStageViewResults} competitionId={competitionId}/>
                : <CompetitorViewResults result={currentCompetitorViewResults} competitionId={competitionId}/>}
      </div>
  )
}
