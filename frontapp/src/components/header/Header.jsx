import React from "react";
import Topbar from "./topbar/Topbar";
import NavPanel from "./navpanel/NavPanel";

export default function Header() {

  return (
      <header>
        <Topbar/>
        <NavPanel/>
      </header>
  )
}
