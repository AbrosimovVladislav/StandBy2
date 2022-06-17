import React from "react";

export default function StagesViewResult({result}) {

  return <div>
    <h2>Results: </h2>
    <p>-------------------------------</p>
    {result?.map(stageInfo => {
      return <div key={Math.random()}>
        <h3>Stage: {stageInfo.stageNumber} {stageInfo.stageName}</h3>
        {stageInfo?.stageViewResults?.map(stageResult => {
          return <div key={Math.random()}>
            <p>Place: {stageResult.place}</p>
            <p>Percentage: {stageResult.percentage}</p>
            <p>Points: {stageResult.points}</p>
            <p>HitFactor: {stageResult.hitFactor}</p>
            <p>ResultPoints: {stageResult.resultPoints}</p>
            <p>Competitor: {stageResult.competitor}</p>
            <p>Rank: {stageResult.rank}</p>
            <p>GunType: {stageResult.gunType}</p>
            <p>GunClass: {stageResult.gunClass}</p>
            <p>Region: {stageResult.region}</p>
            <p>_____________________________</p>
          </div>
        })}
      </div>
    })}
  </div>
}
