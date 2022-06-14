import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import {BrowserRouter} from "react-router-dom";
import {Provider} from "react-redux";
import store from "./redux/store";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'react-toastify/dist/ReactToastify.css';

import './components/header/header.scss';
import './components/header/topbar/topbar.scss';
import './components/header/navpanel/nav-panel.scss';
import './components/header/navpanel/logo/logo.scss';
import './components/header/navpanel/menu/menu.scss';
import './variables/variables.scss';

import './App.scss';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <BrowserRouter>
      <Provider store={store}>
        <App/>
      </Provider>
    </BrowserRouter>,
);

