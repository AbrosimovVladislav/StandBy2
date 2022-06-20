import {
  PUT_COMPETITIONS,
  PUT_CURRENT_COMPETITION,
  PUT_CURRENT_COMPETITOR_VIEW_RESULTS,
  PUT_CURRENT_OVERALL_RESULTS,
  PUT_CURRENT_STAGE_VIEW_RESULTS, SET_VIEW_SWITCHER_COMPETITOR,
  SET_VIEW_SWITCHER_OVERALL,
  SET_VIEW_SWITCHER_STAGE
} from "../actions";

const initialState = {
  competitions: [],
  currentCompetition: {},
  currentOverallResults: [],
  currentStageViewResults: [],
  currentCompetitorViewResults: [],
  viewSwitcher: 'OVERALL' //OVERALL, STAGE, COMPETITOR
};

export default function competitionsReducer(state = initialState, action) {
  switch (action.type) {
    case PUT_COMPETITIONS :
      const competitions = action.payload;
      return {...state, competitions: competitions};
    case PUT_CURRENT_COMPETITION :
      const currentCompetition = action.payload;
      return {...state, currentCompetition: currentCompetition};

    case PUT_CURRENT_OVERALL_RESULTS :
      const currentOverallResults = action.payload;
      return {...state, currentOverallResults: currentOverallResults};
    case PUT_CURRENT_STAGE_VIEW_RESULTS :
      const currentStageViewResults = action.payload;
      return {...state, currentStageViewResults: currentStageViewResults};
    case PUT_CURRENT_COMPETITOR_VIEW_RESULTS :
      const currentCompetitorViewResults = action.payload;
      return {...state, currentCompetitorViewResults: currentCompetitorViewResults};

    case SET_VIEW_SWITCHER_OVERALL:
      return {...state, viewSwitcher: 'OVERALL'};
    case SET_VIEW_SWITCHER_STAGE:
      return {...state, viewSwitcher: 'STAGE'};
    case SET_VIEW_SWITCHER_COMPETITOR:
      return {...state, viewSwitcher: 'COMPETITOR'};
    default :
      return state;
  }
}