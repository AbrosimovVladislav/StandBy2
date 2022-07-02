import React from "react";

export default function CompetitorViewResults({result}) {

  return <div>
    {
      result?.map(result => {
        return <div>
          <h1>{result?.competitor}</h1>
          <p>Ранг: {result?.rank}</p>
          <p>Оружие: {result?.gunType}</p>
          <p>Класс: {result?.gunClass}</p>
          <p>Регион: {result?.region}</p>
          <table>
            <tr>
              <th>N</th>
              <th>Упражнение</th>
              <th>Очки</th>
              <th>ХитФактор</th>
              <th>Итоговые очки</th>
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