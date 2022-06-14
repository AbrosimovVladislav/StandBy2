import React from "react";
import {ReactComponent as ArrowDown} from "../../../../assets/svg/menu__arrowdown.svg";
import {useSelector} from "react-redux";
import {localUIUrl} from "../../../../variables/network";
import {toast} from "react-toastify";

export default function Menu() {

    const {menuItems} = useSelector((store) => store.menuReducer)

    const showWarning = () => {
        toast.warn("Эта функциональность в данный момент недоступна");
    }

    return (
        <div className="menu">
            {menuItems.map(item =>
                <div className="menu__upper-item__container" key={Math.random()}>
                    <div className="menu__upper-item">
                        <a href={item.routerLink !== "discounts" ? localUIUrl + item.routerLink : undefined}
                           onClick={item.routerLink === "discounts" ? showWarning : undefined}>
                            {item.name}
                            <ArrowDown
                                style={{display: item.childItems && item.childItems.length > 0 ? "" : "none"}}/>
                        </a>
                    </div>
                    <div className="menu-items__container">
                        {item.childItems && item.childItems.map(child =>
                            <div className="menu-item" key={Math.random()}>
                                <a href={localUIUrl + child.routerLink}>
                                    {child.name}
                                </a>
                            </div>
                        )}
                    </div>
                </div>
            )}
        </div>
    )
}
