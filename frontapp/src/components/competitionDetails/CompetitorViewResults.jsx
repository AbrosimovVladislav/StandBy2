import React, {useEffect} from "react";
import {useParams} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {fetchCompetitorPerStageResult} from "../../redux/service/competitionSerivce";

export default function CompetitorViewResults() {

  const {competitionId, competitorName} = useParams();
  const {currentCompetitorPerCompetitionResult} = useSelector((store) => store.competitionsReducer)
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(fetchCompetitorPerStageResult(competitionId, competitorName));
  }, [competitionId, competitorName])

  return <div>
    {
      <div>
        <h1>Name: {currentCompetitorPerCompetitionResult?.competitor}</h1>
        <p>Rank: {currentCompetitorPerCompetitionResult?.rank}</p>
        <p>GunType: {currentCompetitorPerCompetitionResult?.gunType}</p>
        <p>GunClass: {currentCompetitorPerCompetitionResult?.gunClass}</p>
        <p>Region: {currentCompetitorPerCompetitionResult?.region}</p>
        <table>
          <tr>
            <th>StageNumber</th>
            <th>StageName</th>
            <th>Points</th>
            <th>HitFactor</th>
            <th>ResultPoints</th>
          </tr>
          {
            currentCompetitorPerCompetitionResult?.competitorViewResults?.map(res =>{
              return <tr key={Math.random()}>
                <td>{res.stageNumber}</td>
                <td>{res.stageName}</td>
                <td>{res.points}</td>
                <td>{res.hitFactor}</td>
                <td>{res.resultPoints}</td>
              </tr>
                }
            )
          }
        </table>
      </div>
    }
  </div>
}