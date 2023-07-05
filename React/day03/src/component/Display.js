import React from "react";

const Display = (props) => {
    return (
        <div>
            <h3>Display 컴포넌트</h3>
            <p>내가 좋아하는 동물은 {props.name}</p>
        </div>
    );
};

export default Display;
