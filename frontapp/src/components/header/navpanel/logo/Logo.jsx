import React from "react";
import {ReactComponent as GMLogo} from "../../../../assets/svg/GUNMARKET.svg";

export default function Logo() {

    return (
        <div className="logo-container">
            <div className="logo">
                <a href={"/"}>
                    <GMLogo/>
                </a>
            </div>
        </div>
    )
}

