import React from "react";

const Test02 = () => {
    const title = "신상명세서";
    const arr = ["홍길동", "코난", "둘리", "라이언", "네오"];
    const data = [
        { id: 1, name: "홍길동" },
        { id: 2, name: "코난" },
        { id: 3, name: "둘리" },
        { id: 4, name: "라이언" },
        { id: 5, name: "네오" },
    ];
    const css = {
        color: "red",
        backgroundColor: "yellow",
        fontSize: "12px",
        padding: 20,
        margin: 10,
        border: "3px solid #000",
    };

    return (
        <div>
            <h2>{title}</h2>
            <ul style={{ border: "1px solid red" }}>
                {
                    // script 구역

                    arr.map((item, index) => {
                        return (
                            // 반드시 고유한 key값을 주어야 힘
                            <li key={index}>
                                {index} : {item}
                            </li>
                        );
                    })
                }
            </ul>
            <hr />
            <ul style={{ border: "1px solid blue" }}>
                {data.map((item, index) => {
                    return (
                        <li key={item.id}>
                            {item.id} : {item.name}
                        </li>
                    );
                })}
            </ul>
        </div>
    );
};

export default Test02;
