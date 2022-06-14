import React from "react";
import {useParams} from "react-router-dom";
import ResultTab from "./ResultTab";
import {localUIUrl} from "../../variables/network";
import {useSelector} from "react-redux";

export default function CompetitionDetails() {

  const {id} = useParams();
  const {currentCompetition} = useSelector((store) => store.competitionsReducer)

  return (
      <div>
        <div>
          <h1>Name: {currentCompetition.name}</h1>
          <p>Date: {currentCompetition.date}</p>
          <p>Level: {currentCompetition.level}</p>
          <p>Type: {currentCompetition.type}</p>
          <p>Place: {currentCompetition.place}</p>
          <p>Organizer: {currentCompetition.organizer}</p>
        </div>
        <ResultTab overall={currentCompetition.results.overall}/>
      </div>
  )
}
