import './App.scss';
import {Route, Routes} from "react-router-dom";
import Header from "./components/header/Header";
import MainPage from "./components/MainPage";
import CompetitionDetails from "./components/competitionDetails/CompetitionDetails";
import Footer from "./components/Footer";
import Competitions from "./components/Competitions";
import CompetitorViewResults from "./components/competitionDetails/CompetitorViewResults";

function App() {
  return (
      <div className="content">
        <Header/>
        <div className="main">
          <Routes>
            <Route path="/" element={<MainPage/>} exact/>
            <Route path="/competitions"
                   element={<Competitions/>} exact/>
            <Route path="/competition/:competitionId"
                   element={<CompetitionDetails/>} exact/>
            <Route path="/competition/:competitionId/competitor/:competitorName"
                   element={<CompetitorViewResults/>} exact/>
          </Routes>
        </div>
        <Footer/>
      </div>
  );
}

export default App;
