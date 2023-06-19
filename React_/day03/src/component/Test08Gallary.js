import React, { useState } from "react";
import Test08View from "./Test08View";
import dataList from "./Test08Data";
import "../css/Test08.css";

const Test08Gallary = () => {
    const [data, setData] = useState(dataList);
    const [one, setOne] = useState(data[0]);

    const onView = (id) => {
        setOne(data[id - 1]);
    };

    return (
        <div className="wrap2">
            <Test08View one={one} data={data} onView={onView} />
        </div>
    );
};

export default Test08Gallary;
