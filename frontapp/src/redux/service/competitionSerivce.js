import {get} from "./clientService";
import {localBackUrl} from "../../variables/network";
import {
  PUT_COMPETITIONS,
  PUT_CURRENT_COMPETITION,
  PUT_CURRENT_COMPETITOR,
  PUT_CURRENT_COMPETITOR_PER_STAGE
} from "../actions";

const competitionUrlPostfix = '/competition'
const competitorUrlPostfix = '/competitor'

export const fetchCompetitions = () => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitionUrlPostfix);
  if (response) {
    dispatch({type: PUT_COMPETITIONS, payload: response})
  }
}

export const fetchStagesCompetitorResultsByCompetitionIdAndCompetitorId
    = (competitionId, competitorId) => async (dispatch, getState) => {
  const response = await get(
      localBackUrl
      + competitionUrlPostfix + "/" + competitionId
      + competitorUrlPostfix + "/" + competitorId);
  console.log(response)
  if (response) {
    dispatch({type: PUT_CURRENT_COMPETITOR_PER_STAGE, payload: response})
  }
}

export const fetchCompetitorById = (id) => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitorUrlPostfix + "/" + id);
  if (response) {
    dispatch({type: PUT_CURRENT_COMPETITOR, payload: response})
  }
}

export const fetchCompetitionById = (id) => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitionUrlPostfix + "/" + id);
  if (response) {
    dispatch({type: PUT_CURRENT_COMPETITION, payload: response})
  }
}