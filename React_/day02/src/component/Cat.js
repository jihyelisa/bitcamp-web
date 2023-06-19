import React, { useState } from "react";
import dataList from "./CatData";
import CatList from "./CatList";
import "../css/style.css";
import "../css/reset.css";

const Cat = () => {
    const [data, setData] = useState(dataList);
    return (
        <>
            <section className="business">
                <div className="inner">
                    <h2>고양이</h2>
                    <p>고양이들</p>
                    <CatList data={data} />
                </div>
            </section>
        </>
    );
};
export default Cat;
