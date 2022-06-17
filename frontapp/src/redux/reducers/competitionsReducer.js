import {
  PUT_COMPETITIONS,
  PUT_CURRENT_COMPETITION, PUT_CURRENT_COMPETITOR_PER_COMPETITION_RESULT,
  SET_VIEW_SWITCHER_OVERALL,
  SET_VIEW_SWITCHER_STAGE
} from "../actions";

const initialState = {
  competitions: [],
  currentCompetition: {},
  currentCompetitorPerCompetitionResult: {},
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
    case PUT_CURRENT_COMPETITOR_PER_COMPETITION_RESULT :
      const currentCompetitorPerCompetitionResult = action.payload;
      return {...state, currentCompetitorPerCompetitionResult: currentCompetitorPerCompetitionResult};
    case SET_VIEW_SWITCHER_OVERALL:
      return {...state, viewSwitcher: 'OVERALL'};
    case SET_VIEW_SWITCHER_STAGE:
      return {...state, viewSwitcher: 'STAGE'};
    default :
      return state;
  }
}