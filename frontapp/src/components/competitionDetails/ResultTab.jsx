import React from "react";

export default function ResultTab({result}) {

  if (result && result.resultItems) {
    return <div>
      <h2>Results: </h2>
      <p>-------------------------------</p>
      {result.resultItems && result.resultItems.map(resultItem => {
        return <div key={resultItem.place}>
          <p>Place: {resultItem.place}</p>
          <p>Percentage: {resultItem.percentage}</p>
          <p>Points: {resultItem.points}</p>
          <p>Competitor: {resultItem.competitor.person.firstName} {resultItem.competitor.person.lastName}</p>
          <p>Rank: {resultItem.competitor.person.rank}</p>
          <p>Type: {resultItem.competitor.gunType}</p>
          <p>Class: {resultItem.competitor.gunClass}</p>
          <p>Region: {resultItem.competitor.person.region}</p>
          <p>_____________________________</p>
        </div>
      })}
    </div>
  } else {
    return <h3>Results are not ready yet </h3>
  }
}
