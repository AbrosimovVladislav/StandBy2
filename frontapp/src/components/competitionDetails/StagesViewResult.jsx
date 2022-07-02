import React from "react";
import {localUIUrl} from "../../variables/network";

export default function StagesViewResult({result, competitionId}) {
  if (result) {
    return <div>
      {result?.map(stageInfo => {
        return <div key={Math.random()}>
          <h3>{stageInfo.stageNumber}) {stageInfo.stageName}</h3>
          <table>
            <tr>
              <th>Место</th>
              <th>Процент</th>
              <th>Очки</th>
              <th>ХитФактор</th>
              <th>Итоговые очки</th>
              <th>Стрелок</th>
              <th>Ранг</th>
              <th>Оружие</th>
              <th>Класс</th>
              <th>Регион</th>
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
