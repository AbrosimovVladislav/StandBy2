import React, {useEffect} from "react";
import {useParams} from "react-router-dom";
import ResultTab from "./ResultTab";
import {useDispatch, useSelector} from "react-redux";
import {
  fetchCompetitionById,
  setViewSwitcherOverall,
  setViewSwitcherStage
} from "../../redux/service/competitionSerivce";
import StagesViewResult from "./StagesViewResult";

export default function CompetitionDetails() {

  const {competitionId} = useParams();
  const {currentCompetition, viewSwitcher} = useSelector((store) => store.competitionsReducer)
  const dispatch = useDispatch();

  useEffect(() => {
    if (competitionId) {
      dispatch(fetchCompetitionById(competitionId));
    }
  }, [competitionId])

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
            ? <ResultTab result={currentCompetition?.overallResults} competitionId={competitionId}/>
            : <StagesViewResult result={currentCompetition?.competitionResultStageView} competitionId={competitionId}/>}
      </div>
  )
}
