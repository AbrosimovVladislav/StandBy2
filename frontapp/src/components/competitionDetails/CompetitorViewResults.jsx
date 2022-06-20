import React from "react";

export default function CompetitorViewResults({result}) {

  return <div>
    {
      result?.map(result => {
        return <div>
          <h1>Name: {result?.competitor}</h1>
          <p>Rank: {result?.rank}</p>
          <p>GunType: {result?.gunType}</p>
          <p>GunClass: {result?.gunClass}</p>
          <p>Region: {result?.region}</p>
          <table>
            <tr>
              <th>StageNumber</th>
              <th>StageName</th>
              <th>Points</th>
              <th>HitFactor</th>
              <th>ResultPoints</th>
            </tr>
            {
              result?.competitorViewResults?.map(res => {
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
      })
    }
  </div>
}