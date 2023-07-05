import axios from "axios";
import React, { useEffect, useState } from "react";

const Test02 = () => {
    const [id, setId] = useState("1");
    const [dto, setDto] = useState({});
    const [search, setSearch] = useState(1);

    const onSearch = (id) => {
        setSearch(id);
    };

    useEffect(() => {
        axios
            .get(`https://jsonplaceholder.typicode.com/posts/${id}`)
            .then((res) => setDto(res.data));
        // }, [id]); // id 값이 바뀔 때마다
    }, [search]); // 버튼을 누를 때마다

    return (
        <div>
            <input
                type="text"
                value={id}
                onChange={(e) => setId(e.target.value)}
            />
            <button onClick={() => onSearch(id)}>search!</button>
            <hr />
            <h3>
                {dto.id} / {dto.title}
            </h3>
        </div>
    );
};

export default Test02;
