import React from "react";
import {localUIUrl} from "../../variables/network";

export default function ResultTab({result, competitionId}) {

  if (result && result.resultItems) {
    return <div>
      <h2>Results: </h2>
      <p>-------------------------------</p>
      {result.resultItems && result.resultItems.map(resultItem => {
        return <div key={resultItem.place}>
          <a href={localUIUrl + "/competition/" + competitionId + "/competitor/" + resultItem.competitor.competitorId}>
            <p>Place: {resultItem.place}</p>
            <p>Percentage: {resultItem.percentage}</p>
            <p>Points: {resultItem.points}</p>
            <p>Competitor: {resultItem.competitor.person.firstName} {resultItem.competitor.person.lastName}</p>
            <p>Rank: {resultItem.competitor.person.rank}</p>
            <p>Type: {resultItem.competitor.gunType}</p>
            <p>Class: {resultItem.competitor.gunClass}</p>
            <p>Region: {resultItem.competitor.person.region}</p>
          </a>
          <p>_____________________________</p>
        </div>
      })}
    </div>
  } else {
    return <h3>Results are not ready yet </h3>
  }
}
