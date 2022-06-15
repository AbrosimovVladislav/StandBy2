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
          <h1>Name: {currentCompetition?.name}</h1>
          <p>Date: {currentCompetition?.startDate} - {currentCompetition
              && currentCompetition?.endDate}</p>
          <p>Level: {currentCompetition?.level}</p>
          <p>Type: {currentCompetition?.type}</p>
          <p>Place: {currentCompetition?.place?.name}</p>
          <p>Organizer: {currentCompetition?.organizer?.name}</p>
        </div>
        <ResultTab result={currentCompetition?.result} competitionId={competitionId}/>
      </div>
  )
}
