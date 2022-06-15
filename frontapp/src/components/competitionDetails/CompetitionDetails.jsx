import React, {useEffect} from "react";
import {useParams} from "react-router-dom";
import ResultTab from "./ResultTab";
import {useDispatch, useSelector} from "react-redux";
import {fetchCompetitionById} from "../../redux/service/competitionSerivce";

export default function CompetitionDetails() {

  const {id} = useParams();
  const {currentCompetition} = useSelector((store) => store.competitionsReducer)
  const dispatch = useDispatch();

  useEffect(() => {
    if (id) {
      dispatch(fetchCompetitionById(id));
    }
  }, [id])

  return (
      <div>
        <div>
          <h1>Name: {currentCompetition.name}</h1>
          <p>Date: {currentCompetition.startDate} - {currentCompetition.endDate}</p>
          <p>Level: {currentCompetition.level}</p>
          <p>Type: {currentCompetition.type}</p>
          <p>Place: {currentCompetition.place.name}</p>
          <p>Organizer: {currentCompetition.organizer.name}</p>
        </div>
        <ResultTab overall={currentCompetition.results && currentCompetition.results.overall}/>
      </div>
  )
}
