import React from "react";

const Fruit = ({ fruit, onInputFruit }) => {
    return (
        <>
            과일 <input type="text" value={fruit} onChange={onInputFruit} />
        </>
    );
};

export default Fruit;
