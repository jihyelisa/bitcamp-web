import React from "react";
import { Link, Route, Routes, useNavigate } from "react-router-dom";

const Member = ({ item }) => {
    const { id, name, email } = item;
    const navigate = useNavigate();

    const css = {
        border: "1px solid cyan",
        margin: 20,
        padding: 20,
    };

    const onGo = () => {
        navigate(`/member/${id}`);
    };

    return (
        <div style={css}>
            {id} / {name} / {email}
            <p>
                <Link to={`/member/${id}`}>자세히 보기</Link>
            </p>
            <button onClick={onGo}>상세보기</button>
        </div>
    );
};

export default Member;
