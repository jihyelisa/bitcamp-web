import React, { useRef, useState } from "react";

const Test10 = () => {
    const seq = useRef(1);
    const nameRef = useRef();
    const [data, setData] = useState([]);
    const [form, setForm] = useState({
        name: "",
        age: "",
    });
    const { name, age } = form;

    const onInput = (e) => {
        const { name, value } = e.target;

        setForm({
            // 중괄호 열었으므로 객체 복사
            ...form,
            [name]: value,
        });
    };

    const onAdd = (e) => {
        //브라우저 고유의 동작을 중단
        // (여기서는 submit에 의한 페이지 이동 막아줌)
        e.preventDefault();

        if (!name || !age) return;

        setData([
            // 대괄호 열었으므로 객체 복사x, 배열 추가o
            ...data,
            {
                seq: seq.current++,
                name, // name: name → key: value 가 동일하면 한 번만 써도 됨
                age,
            },
        ]);

        // 초기화
        setForm({
            name: "",
            age: "",
        });

        nameRef.current.focus();
    };

    return (
        <div>
            <form onSubmit={onAdd}>
                이름:{" "}
                <input
                    type="text"
                    name="name"
                    value={name}
                    onChange={onInput}
                    ref={nameRef}
                />
                <br />
                나이:{" "}
                <input type="text" name="age" value={age} onChange={onInput} />
                <br />
                <button type="submit">추가</button>
            </form>

            <hr />
            <ul>
                {data.map((item) => (
                    <li>
                        {item.seq} {item.name} : {item.age}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Test10;
