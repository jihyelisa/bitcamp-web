import React from "react";

const Output = (props) => {
    return (
        <div>
            <p>
                {props.name}님이 좋아하는 과일은 {props.fruit}입니다.
            </p>
        </div>
    );
};

export default Output;
