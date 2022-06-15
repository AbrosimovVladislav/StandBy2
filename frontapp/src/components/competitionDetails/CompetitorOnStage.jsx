import React, {useEffect} from "react";
import {useParams} from "react-router-dom";
import {
  fetchCompetitorById,
  fetchStagesCompetitorResultsByCompetitionIdAndCompetitorId
} from "../../redux/service/competitionSerivce";
import {useDispatch, useSelector} from "react-redux";

export default function CompetitorOnStage() {

  const {competitionId, competitorId} = useParams();
  const {currentCompetitor, currentCompetitorPerStage} = useSelector((store) => store.competitionsReducer);
  const dispatch = useDispatch();

  useEffect(() => {
    if (competitionId && competitorId) {
      dispatch(fetchCompetitorById(competitorId));
      dispatch(fetchStagesCompetitorResultsByCompetitionIdAndCompetitorId(competitionId, competitorId));
    }
  }, [competitionId, competitorId])

  return <div>
    <h1>{currentCompetitor?.person?.firstName} {currentCompetitor?.person?.lastName}</h1>
    {currentCompetitorPerStage[0]
        && currentCompetitorPerStage[0].stageResultItems
        && currentCompetitorPerStage[0].stageResultItems.map(
            stageResultItem => {
              return <div>
                <h2>Stage: {stageResultItem.stageNumber}</h2>
                <h2>{stageResultItem.stageName}</h2>
                <p>Place: {stageResultItem.place}</p>
                <p>Percent: {stageResultItem.percentage}</p>
                <p>Points: {stageResultItem.points}</p>
              </div>
            }
        )}
  </div>
}
