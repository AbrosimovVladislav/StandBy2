import React, {useEffect} from "react";
import {useDispatch, useSelector} from "react-redux";
import {fetchCompetitions} from "../redux/service/competitionSerivce";
import {localUIUrl} from "../variables/network";

export default function Competitions() {

  const {competitions} = useSelector((store) => store.competitionsReducer)
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(fetchCompetitions());
  }, [])

  return (
      <div>
        Competitions
        {competitions?.map(competition => {
          return <div key={competition.competitionId}>
            <a href={localUIUrl + "/competition/" + competition.competitionId}><h1>Name: {competition.name}</h1></a>
            <p>Date: {competition.startDate} - {competition.finishDate}</p>
            <p>Level: {competition.level}</p>
            <p>Type: {competition.gunType}</p>
            <p>Place: {competition.place}</p>
            <p>Organizer: {competition.organizer}</p>
            <p>Price: {competition.price} Р.</p>
            <p>Match Director: {competition.matchDirector}</p>
          </div>
        })}
      </div>
  )
}
