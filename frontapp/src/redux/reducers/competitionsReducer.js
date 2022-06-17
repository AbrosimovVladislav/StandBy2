import {
  PUT_COMPETITIONS,
  PUT_CURRENT_COMPETITION,
  SET_VIEW_SWITCHER_OVERALL,
  SET_VIEW_SWITCHER_STAGE
} from "../actions";

const initialState = {
  competitions: [],
  currentCompetition: {},
  viewSwitcher: 'OVERALL' //OVERALL, STAGE
};

export default function competitionsReducer(state = initialState, action) {
  switch (action.type) {
    case PUT_COMPETITIONS :
      const competitions = action.payload;
      return {...state, competitions: competitions};
    case PUT_CURRENT_COMPETITION :
      const currentCompetition = action.payload;
      return {...state, currentCompetition: currentCompetition};
    case SET_VIEW_SWITCHER_OVERALL:
      return {...state, viewSwitcher: 'OVERALL'};
    case SET_VIEW_SWITCHER_STAGE:
      return {...state, viewSwitcher: 'STAGE'};
    default :
      return state;
  }
}