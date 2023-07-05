import React from "react";

const Test07Input = ({ data, onInput, onNext }) => {
    const { name, age, addr, phone } = data;

    return (
        <>
            <table border="1">
                <tr>
                    <th>이름</th>
                    <td>
                        <input
                            type="text"
                            name="name"
                            value={name}
                            onChange={onInput}
                            // ref={nameRef}
                        />
                    </td>
                </tr>
                <tr>
                    <th>나이</th>
                    <td>
                        <input
                            type="text"
                            name="age"
                            value={age}
                            onChange={onInput}
                        />
                    </td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td>
                        <input
                            type="text"
                            name="addr"
                            value={addr}
                            onChange={onInput}
                        />
                    </td>
                </tr>
                <tr>
                    <th>전화</th>
                    <td>
                        <input
                            type="text"
                            name="phone"
                            value={phone}
                            onChange={onInput}
                        />
                    </td>
                </tr>
            </table>
            <br />
            <button onClick={onNext}>다음</button>
        </>
    );
};

export default Test07Input;
