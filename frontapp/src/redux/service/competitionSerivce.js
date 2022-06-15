import {get} from "./clientService";
import {localBackUrl} from "../../variables/network";
import {PUT_COMPETITIONS} from "../actions";

const competitionUrlPostfix = '/competition'

export const fetchCompetitions = () => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitionUrlPostfix);
  console.log(response)
  if(response){
    dispatch({type: PUT_COMPETITIONS, payload: response})
  }
}