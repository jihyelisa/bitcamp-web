import React, { useEffect, useState } from "react";
import axios from "axios";
import Member from "./Member";

const Main = () => {
    useEffect(() => {
        const url = `https://jsonplaceholder.typicode.com/users`;
        axios.get(url).then((res) => {
            setData(res.data);
        });
    }, []);

    const [data, setData] = useState([]);

    return (
        <div>
            <h1>Main Page / 회원수: {data.length}</h1>

            {data.map((item) => (
                <Member key={item.id} item={item} />
            ))}
        </div>
    );
};

export default Main;
