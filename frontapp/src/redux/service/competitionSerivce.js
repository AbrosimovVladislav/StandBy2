import {get} from "./clientService";
import {localBackUrl} from "../../variables/network";

const competitionUrlPostfix = '/competition'

export const fetchCompetitions = () => async (dispatch, getState) => {
  const response = await get(localBackUrl + competitionUrlPostfix);

}