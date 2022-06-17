import React from "react";
import {localUIUrl} from "../../variables/network";

export default function StagesViewResult({result, competitionId}) {
  if (result) {
    return <div>
      <h2>Results: </h2>
      {result?.map(stageInfo => {
        return <div key={Math.random()}>
          <h3>Stage: {stageInfo.stageNumber} {stageInfo.stageName}</h3>
          <table>
            <tr>
              <th>Place</th>
              <th>Percentage</th>
              <th>Points</th>
              <th>HitFactor</th>
              <th>ResultPoints</th>
              <th>Competitor</th>
              <th>Rank</th>
              <th>GunType</th>
              <th>GunClass</th>
              <th>Region</th>
            </tr>
            {stageInfo?.stageViewResults?.map(stageResult => {
              return <tr key={Math.random()}>
                <td>{stageResult.place}</td>
                <td>{stageResult.percentage}</td>
                <td>{stageResult.points}</td>
                <td>{stageResult.hitFactor}</td>
                <td>{stageResult.resultPoints}</td>
                <a href={localUIUrl + "/competition/" + competitionId + "/competitor/"
                    + stageResult.competitor}>
                  <td>{stageResult.competitor}</td>
                </a>
                <td>{stageResult.rank}</td>
                <td>{stageResult.gunType}</td>
                <td>{stageResult.gunClass}</td>
                <td>{stageResult.region}</td>
              </tr>
            })}
          </table>
        </div>
      })}
    </div>
  } else {
    return <h3>Results are not ready yet </h3>
  }
}
