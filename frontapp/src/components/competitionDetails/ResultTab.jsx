import React from "react";

export default function ResultTab({overall}) {

  if(overall){
    return <div>
      <h2>Results: </h2>
      <p>-------------------------------</p>
      {overall && overall.map(result => {
        return <div key={result.place}>
          <p>Place: {result.place}</p>
          <p>Percentage: {result.percentage}</p>
          <p>Points: {result.points}</p>
          <p>Competitor: {result.competitor}</p>
          <p>Rank: {result.competitorsRank}</p>
          <p>Type: {result.type}</p>
          <p>Class: {result.class}</p>
          <p>Region: {result.region}</p>
          <p>_____________________________</p>
        </div>
      })}
    </div>
  } else {
    return <h3>Results are not ready yet </h3>
  }
}
