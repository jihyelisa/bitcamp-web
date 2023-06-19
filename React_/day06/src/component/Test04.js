import React, { useEffect, useReducer } from "react";
import axios from "axios";

const initialState = { data: {}, error: null, loading: true };

const reducer = (state, action) => {
    switch (action.type) {
        case "SUCCESS":
            return {
                data: action.payload,
                error: null,
                loading: false,
            };
        case "ERROR":
            return {
                data: {},
                error: "에러가 발생했습니다",
                loading: true,
            };
        default:
            return state;
    }
};

const Test04 = () => {
    const [state, dispatch] = useReducer(reducer, initialState);

    useEffect(() => {
        const url = "https://jsonplaceholder.typicode.com/posts/3";
        axios
            .get(url)
            .then((res) => {
                dispatch({ type: "SUCCESS", payload: res.data });
            })
            .catch((error) => {
                dispatch({ type: "ERROR" });
            });
    });

    return (
        <div>
            <h2>{state.data && state.loading ? "로딩중" : state.data.title}</h2>
            <p>{state.error ? state.error : null}</p>
        </div>
    );
};

export default Test04;
