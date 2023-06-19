import React, { useState } from "react";

const Test02 = () => {
    const [chk, setChk] = useState(false);
    const onCheck = (event) => {
        const { checked } = event.target;
        setChk(checked);
    };

    return (
        <div style={{ color: chk ? "blue" : "red", fontSize: 25, margin: 30 }}>
            <input type="checkbox" checked={chk} onChange={onCheck} />
            Have a nice day!
        </div>
    );
};

export default Test02;
