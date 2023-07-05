import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate, useParams } from "react-router-dom";

const MemberDetail = () => {
    const { memberId } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        const url = `https://jsonplaceholder.typicode.com/users/${memberId}`;
        axios.get(url).then((res) => {
            setMember(res.data);
        });
    }, [memberId]);
    const [member, setMember] = useState({});
    const { name, email, phone, website } = member;

    const onBack = () => {
        // navigate("/")
        navigate(-1);
    };

    const css = {
        border: "1px solid cyan",
        margin: 20,
        padding: 20,
    };

    return (
        <div style={css}>
            <h2>MemberDetail Page: {memberId}</h2>
            <h4>이름: {name}</h4>
            <ul>
                <li>email: {email}</li>
                <li>phone: {phone}</li>
                <li>website: {website}</li>
            </ul>
            <button onClick={onBack}>back</button>
        </div>
    );
};

export default MemberDetail;
