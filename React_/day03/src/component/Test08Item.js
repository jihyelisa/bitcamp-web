import React from "react";

const Test08Item = ({ item, onView }) => {
    return (
        <li className="listItem" onClick={() => onView(item.id)}>
            <img src={item.img} />
        </li>
    );
};

export default Test08Item;
