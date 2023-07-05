import React from "react";

const Test5Sub = ({ name, age, tel, addr, done, color, bgcolor }) => {
    const css = {
        color: color,
        backgroundColor: bgcolor,
    };

    return (
        <div style={css}>
            <h2>신상명세서</h2>
            <ul>
                <li>이름: {name}</li>
                <li>나이: {age}</li>
                <li>전화: {tel}</li>
                <li>주소: {addr}</li>
                <li>
                    동의 여부: {done} {done ? "동의" : "비동의"}
                </li>
            </ul>
        </div>
    );
};

export default Test5Sub;
