import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import NavBar from "./page02/NavBar";
import Home from "./page02/Home";
import About from "./page02/About";
import Ceo from "./page02/Ceo";
import Sub01 from "./page02/Sub01";
import NotFiles from "./page02/NotFiles";
import "./css/style02.css";

const App02 = () => {
    return (
        <>
            <BrowserRouter>
                <NavBar />

                {/* 화면에 보이는 영역 */}
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/about" element={<About />} />
                    <Route path="/ceo" element={<Ceo />} />
                    <Route path="/sub01" element={<Sub01 />} />
                    <Route path="*" element={<NotFiles />} />
                </Routes>
            </BrowserRouter>
        </>
    );
};

export default App02;
