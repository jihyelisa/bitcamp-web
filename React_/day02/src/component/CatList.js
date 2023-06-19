import React from "react";
import CatItem from "./CatItem";

const CatList = ({ data }) => {
    return (
        <ul className="list2">
            {data.map((item) => (
                <CatItem item={item} />
            ))}
        </ul>
    );
};

export default CatList;
