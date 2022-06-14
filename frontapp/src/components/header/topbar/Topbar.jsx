import React from "react";
import {Link} from "react-router-dom";
import {toast} from "react-toastify";

export default function Topbar() {

  const showWarning = () => {
    toast.warn("Эта функциональность в данный момент недоступна");
  }

  return (
      <div className="topbar">
        <div className="container">
          <div className="topbar__content">
            <div className="topbar__links">
              <Link to={"/about-us"} onClick={showWarning}>О нас</Link>
              <Link to={"/jobs"} onClick={showWarning}>Вакансии</Link>
              <Link to={{}} onClick={showWarning}>Сотрудничество</Link>
            </div>
          </div>
        </div>
      </div>
  )
}
