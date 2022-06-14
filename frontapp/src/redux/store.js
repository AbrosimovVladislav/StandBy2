import {applyMiddleware, combineReducers, createStore} from "redux";
import {composeWithDevTools} from "redux-devtools-extension";
import thunk from "redux-thunk";
import menuReducer from "./reducers/menuReducer";
import competitionsReducer from "./reducers/competitionsReducer";

const rootReducer = combineReducers({
  menuReducer,
  competitionsReducer,
})

const store = createStore(rootReducer, composeWithDevTools(applyMiddleware(thunk)));
export default store;