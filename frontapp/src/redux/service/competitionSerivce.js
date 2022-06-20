import {get} from "./clientService";
import {localBackUrl} from "../../variables/network";
import {
  PUT_COMPETITIONS,
  PUT_CURRENT_COMPETITION,
  PUT_CURRENT_COMPETITION_OVERALL_RESULTS,
  PUT_CURRENT_COMPETITION_STAGE_VIEW_RESULTS,
  PUT_CURRENT_COMPETITOR_PER_COMPETITION_RESULT,
  SET_VIEW_SWITCHER_OVERALL,
  SET_VIEW_SWITCHER_STAGE
} from "../actions";

const competitionUrlPostfix = '/competition'
const competitorUrlPostfix = '/competitor'
const overallResultsPostfix = '/overall'
const stageViewResultsPostfix = '/stageView'

export const fetchCompetitions = () => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitionUrlPostfix);
  if (response) {
    dispatch({type: PUT_COMPETITIONS, payload: response})
  }
}

export const fetchCompetitorPerStageResult = (competitionId, competitorName) => async (dispatch, getState) => {
  const response = await get(
      localBackUrl + competitionUrlPostfix + "/" + competitionId + competitorUrlPostfix + "/" + competitorName);
  if (response) {
    dispatch({type: PUT_CURRENT_COMPETITOR_PER_COMPETITION_RESULT, payload: response})
  }
}

export const fetchCompetitionById = (id) => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitionUrlPostfix + "/" + id);
  if (response) {
    dispatch({type: PUT_CURRENT_COMPETITION, payload: response})
  }
}

export const fetchOverallResultsByCompetitionId = (id) => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitionUrlPostfix + "/" + id + overallResultsPostfix);
  if (response) {
    dispatch({type: PUT_CURRENT_COMPETITION_OVERALL_RESULTS, payload: response})
  }
}

export const fetchStageViewResultsByCompetitionId = (id) => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitionUrlPostfix + "/" + id + stageViewResultsPostfix);
  if (response) {
    dispatch({type: PUT_CURRENT_COMPETITION_STAGE_VIEW_RESULTS, payload: response})
  }
}

export const setViewSwitcherOverall = () => async (dispatch, getState) => {
  dispatch({type: SET_VIEW_SWITCHER_OVERALL})
}

export const setViewSwitcherStage = () => async (dispatch, getState) => {
  dispatch({type: SET_VIEW_SWITCHER_STAGE})
}