import {
  PUT_COMPETITIONS,
  PUT_CURRENT_COMPETITION,
  PUT_CURRENT_COMPETITOR,
  PUT_CURRENT_COMPETITOR_PER_STAGE
} from "../actions";

const initialState = {
  competitions: [],
  currentCompetition: {},
  currentCompetitor: {},
  currentCompetitorPerStage:[]
};

export default function competitionsReducer(state = initialState, action) {
  switch (action.type) {
    case PUT_COMPETITIONS :
      const competitions = action.payload;
      return {...state, competitions: competitions};
    case PUT_CURRENT_COMPETITION :
      const currentCompetition = action.payload;
      return {...state, currentCompetition: currentCompetition};
    case PUT_CURRENT_COMPETITOR :
      const currentCompetitor = action.payload;
      return {...state, currentCompetitor: currentCompetitor};
    case PUT_CURRENT_COMPETITOR_PER_STAGE :
      const currentCompetitorPerStage = action.payload;
      return {...state, currentCompetitorPerStage: currentCompetitorPerStage};
    default :
      return state;
  }
}