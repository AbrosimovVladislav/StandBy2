import React, {useEffect} from "react";
import {localUIUrl} from "../../variables/network";

export default function OverallResult({result, competitionId}) {

  useEffect(() => {
    console.log("result")
    console.log(result)
  },[])

  if (result) {
    console.log("YES")
    console.log(result)
    return <div>
      <h2>Results: </h2>
      <table>
        <tr>
          <th>Place</th>
          <th>Percentage</th>
          <th>Points</th>
          <th>Competitor</th>
          <th>Rank</th>
          <th>Type</th>
          <th>Class</th>
          <th>Region</th>
        </tr>
        {result?.map(resultItem => {
          return <tr>
            <td>{resultItem?.place}</td>
            <td>{resultItem?.percentage}</td>
            <td>{resultItem?.points}</td>
            <a href={localUIUrl + "/competition/" + competitionId + "/competitor/"
                + resultItem?.competitor}>
              <td>{resultItem?.competitor}</td>
            </a>
            <td>{resultItem?.rank}</td>
            <td>{resultItem?.gunType}</td>
            <td>{resultItem?.gunClass}</td>
            <td>{resultItem?.region}</td>
          </tr>
        })}
      </table>
    </div>
  } else {
    console.log("NO")
    console.log(result)
    return <h3>Results are not ready yet </h3>
  }
}

