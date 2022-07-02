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
            <a href={localUIUrl + "/competition/" + competition.competitionId}><h1>{competition.name}</h1></a>
            {/*<p>Date: {competition.startDate} - {competition.finishDate}</p>*/}
            <p>Дата: 29.07.2022 - 30.07.2022</p>
            <p>Уровень: {competition.level}</p>
            <p>Класс: {competition.gunType}</p>
            <p>Место: {competition.place}</p>
            <p>Организатор: {competition.organizer}</p>
            <p>Входной билет: {competition.price} Р.</p>
            <p>Директор Матча: {competition.matchDirector}</p>
          </div>
        })}
      </div>
  )
}
