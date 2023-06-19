import React, { useState } from "react";
import "../css/Test06.css";

const Test06 = () => {
    const [data, setData] = useState([
        { seq: 1, name: "hong", age: 20, addr: "seoul", done: true },
        { seq: 2, name: "ryan", age: 25, addr: "jeju", done: true },
        { seq: 3, name: "neo", age: 26, addr: "ulsan", done: false },
        { seq: 4, name: "frodo", age: 22, addr: "busan", done: true },
        { seq: 5, name: "conan", age: 28, addr: "kyungki", done: false },
    ]);

    return (
        <div>
            <table className="list">
                <caption>신상명세서</caption>
                <colgroup>
                    <col className="seq"></col>
                    <col className="name"></col>
                    <col className="age"></col>
                    <col className="addr"></col>
                    <col className="done"></col>
                </colgroup>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>이름</th>
                        <th>나이</th>
                        <th>주소</th>
                        <th>동의 여부</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((item) => {
                        return (
                            <tr key={item.seq}>
                                <td>{item.seq}</td>
                                <td>{item.name}</td>
                                <td>{item.age}</td>
                                <td>{item.addr}</td>
                                <td>{item.done ? "동의" : "비동의"}</td>
                            </tr>
                        );
                    })}
                </tbody>
            </table>
        </div>
    );
};

export default Test06;
