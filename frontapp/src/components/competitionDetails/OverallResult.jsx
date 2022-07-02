import React from "react";
import {localUIUrl} from "../../variables/network";

export default function OverallResult({result, competitionId}) {
  if (result) {
    return <div>
      <table>
        <tr>
          <th>Место</th>
          <th>Процент</th>
          <th>Очки</th>
          <th>Стрелок</th>
          <th>Ранг</th>
          <th>Оружие</th>
          <th>Класс</th>
          <th>Регион</th>
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
    return <h3>Results are not ready yet </h3>
  }
}

