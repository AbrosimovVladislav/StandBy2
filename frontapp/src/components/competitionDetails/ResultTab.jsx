import React from "react";
import {localUIUrl} from "../../variables/network";

export default function ResultTab({result, competitionId}) {

  if (result) {
    return <div>
      <h2>Results: </h2>
      <p>-------------------------------</p>
      {result?.map(resultItem => {
        return <div key={resultItem.place}>
          <a href={localUIUrl + "/competition/" + competitionId + "/competitor/" + resultItem.competitor.competitorId}>
            <p>Place: {resultItem.place}</p>
            <p>Percentage: {resultItem.percentage}</p>
            <p>Points: {resultItem.points}</p>
            <p>Competitor: {resultItem.competitor}</p>
            <p>Rank: {resultItem.rank}</p>
            <p>Type: {resultItem.gunType}</p>
            <p>Class: {resultItem.gunClass}</p>
            <p>Region: {resultItem.region}</p>
          </a>
          <p>_____________________________</p>
        </div>
      })}
    </div>
  } else {
    return <h3>Results are not ready yet </h3>
  }
}
