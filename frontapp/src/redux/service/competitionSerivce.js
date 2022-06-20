import {get} from "./clientService";
import {localBackUrl} from "../../variables/network";
import {
  PUT_COMPETITIONS,
  PUT_CURRENT_COMPETITION,
  PUT_CURRENT_COMPETITOR_VIEW_RESULTS,
  PUT_CURRENT_OVERALL_RESULTS,
  PUT_CURRENT_STAGE_VIEW_RESULTS, SET_VIEW_SWITCHER_COMPETITOR,
  SET_VIEW_SWITCHER_OVERALL,
  SET_VIEW_SWITCHER_STAGE
} from "../actions";

const competitionUrlPostfix = '/competition'
const overallResultsPostfix = '/overall'
const stageViewResultsPostfix = '/stageView'
const competitorViewResultsPostfix = '/competitor'

export const fetchCompetitions = () => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitionUrlPostfix);
  if (response) {
    dispatch({type: PUT_COMPETITIONS, payload: response})
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
    dispatch({type: PUT_CURRENT_OVERALL_RESULTS, payload: response})
  }
}

export const fetchStageViewResultsByCompetitionId = (id) => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitionUrlPostfix + "/" + id + stageViewResultsPostfix);
  if (response) {
    dispatch({type: PUT_CURRENT_STAGE_VIEW_RESULTS, payload: response})
  }
}

export const fetchCompetitorViewResultsByCompetitionId = (id) => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitionUrlPostfix + "/" + id + competitorViewResultsPostfix);
  if (response) {
    dispatch({type: PUT_CURRENT_COMPETITOR_VIEW_RESULTS, payload: response})
  }
}

export const setViewSwitcherOverall = () => async (dispatch, getState) => {
  dispatch({type: SET_VIEW_SWITCHER_OVERALL})
}

export const setViewSwitcherStage = () => async (dispatch, getState) => {
  dispatch({type: SET_VIEW_SWITCHER_STAGE})
}

export const setViewSwitcherCompetitor = () => async (dispatch, getState) => {
  dispatch({type: SET_VIEW_SWITCHER_COMPETITOR})
}