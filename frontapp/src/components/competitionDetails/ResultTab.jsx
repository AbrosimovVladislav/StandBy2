import React from "react";

export default function ResultTab({overall}) {

  return (
      <div>
        <h1>Results: </h1>
        <p>-------------------------------</p>
        {overall?.map(result => {
          return <div>
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
  )
}
