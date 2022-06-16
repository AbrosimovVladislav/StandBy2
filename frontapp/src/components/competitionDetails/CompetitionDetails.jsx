import React, {useEffect} from "react";
import {useParams} from "react-router-dom";
import ResultTab from "./ResultTab";
import {useDispatch, useSelector} from "react-redux";
import {fetchCompetitionById} from "../../redux/service/competitionSerivce";

export default function CompetitionDetails() {

  const {competitionId} = useParams();
  const {currentCompetition} = useSelector((store) => store.competitionsReducer)
  const dispatch = useDispatch();

  useEffect(() => {
    if (competitionId) {
      dispatch(fetchCompetitionById(competitionId));
    }
  }, [competitionId])

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
        <ResultTab result={currentCompetition?.overallResults} competitionId={competitionId}/>
      </div>
  )
}
