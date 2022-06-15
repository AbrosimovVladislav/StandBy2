import {get} from "./clientService";
import {localBackUrl} from "../../variables/network";
import {PUT_COMPETITIONS, PUT_CURRENT_COMPETITION} from "../actions";

const competitionUrlPostfix = '/competition'

export const fetchCompetitions = () => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitionUrlPostfix);
  if(response){
    dispatch({type: PUT_COMPETITIONS, payload: response})
  }
}

export const fetchCompetitionById = (id) => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitionUrlPostfix + "/" + id);
  if(response){
    dispatch({type: PUT_CURRENT_COMPETITION, payload: response})
  }
}