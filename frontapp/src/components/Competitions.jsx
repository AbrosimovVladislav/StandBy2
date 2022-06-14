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
          return <div>
            <a href={localUIUrl + "/competition/" + competition.id}><h1>Name: {competition.name}</h1></a>
            <p>Date: {competition.date}</p>
            <p>Level: {competition.level}</p>
            <p>Type: {competition.type}</p>
            <p>Place: {competition.place}</p>
            <p>Organizer: {competition.organizer}</p>
          </div>
        })}
      </div>
  )
}
