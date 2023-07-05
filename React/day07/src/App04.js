import React from "react";
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import Main from "./page04/Main";
import MemberDetail from "./page04/MemberDetail";

const App04 = () => {
    return (
        <BrowserRouter>
            <>
                <Routes>
                    <Route path="/" element={<Main />} />
                    <Route
                        path="/member/:memberId"
                        element={<MemberDetail />}
                    />
                </Routes>
            </>
        </BrowserRouter>
    );
};

export default App04;
