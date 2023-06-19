import React, { useState } from "react";

const Test04 = () => {
    const [visible, setVisible] = useState(true);
    const onShow = () => {
        setVisible(true);
    };
    const onHide = () => {
        setVisible(false);
    };
    const onToggle = () => {
        // visible ? setVisible(false) : setVisible(true);
        setVisible(!visible);
    };

    return (
        <div>
            <button onClick={onShow}>보이기</button>
            <button onClick={onHide}>숨기기</button>
            <button onClick={onToggle}>{visible ? "숨기기" : "보이기"}</button>
            <hr />
            {visible && ( // && - 조건이 참일 때 실행
                <div
                    style={{
                        width: 300,
                        height: 300,
                        margin: 20,
                        background: "pink",
                    }}
                ></div>
            )}
        </div>
    );
};

export default Test04;
