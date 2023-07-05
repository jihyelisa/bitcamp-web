import React from "react";

const Test07Output = ({ name, onPrev }) => {
    return (
        <>
            <h3>{name}님</h3>
            <h3>설문조사 참여 감사합니다</h3>

            <button onClick={onPrev}>이전</button>
        </>
    );
};

export default Test07Output;
