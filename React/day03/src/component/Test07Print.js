import React from "react";

const Test07Print = ({ name, age, addr, phone, onPrev, onNext }) => {
    return (
        <>
            <ul>
                <li>
                    이름: <em>{name}</em>
                </li>
                <li>
                    나이: <em>{age}</em>
                </li>
                <li>
                    주소: <em>{addr}</em>
                </li>
                <li>
                    전화: <em>{phone}</em>
                </li>
            </ul>

            <button onClick={onPrev}>이전</button>
            <button onClick={onNext}>다음</button>
        </>
    );
};

export default Test07Print;
