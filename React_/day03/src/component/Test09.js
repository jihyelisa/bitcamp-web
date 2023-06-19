import React from "react";
import img01 from "../img/tree01.jpeg";
import img02 from "../img/tree02.jpeg";
import img03 from "../img/tree03.jpeg";
import img04 from "../img/tree04.jpeg";

const Test09 = () => {
    return (
        <div>
            <img src={img01} style={{ width: 200, height: 200 }} />
            <img src={img02} style={{ width: 200, height: 200 }} />
            <img src={img03} style={{ width: 200, height: 200 }} />
            <img src={img04} style={{ width: 200, height: 200 }} />
        </div>
    );
};

export default Test09;
