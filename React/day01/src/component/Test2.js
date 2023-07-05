import React from "react";

const Test2 = () => {
    // JavaScript 함수 영역
    // 조건문, 제어문 등 사용 가능
    let title = "신상명세서";
    const name = "홍길동";
    const age = 25;
    const addr = "Seoul";

    const css1 = {
        color: "red",
        backgroundColor: "yellow",
        fontSize: "12px",
        padding: 20,
        margin: 10,
        border: "3px solid #000",
    };

    const css2 = {
        width: "400px",
        backgroundColor: "hotpink",
        fontSize: "20px",
        padding: "13px",
        margin: "30px",
    };

    return (
        <>
            <h2>JSX 영역</h2>
            <h2 style={css1}>{title}</h2>
            <ul>
                <li style={css2}>이름 : {name}</li>
                <li
                    style={{
                        backgroundColor: "greenyellow",
                        padding: 15,
                        margin: "auto",
                    }}
                >
                    나이 : {age}살 {age > 19 ? "성인" : "청소년"}
                </li>
                <li>주소 : {addr}</li>
            </ul>
        </>
    );
};

export default Test2;
