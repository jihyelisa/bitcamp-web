import React from "react";
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import Home from "./page01/Home";
import About from "./page01/About";
import Ceo from "./page01/Ceo";
import Sub01 from "./page01/Sub01";
import NotFiles from "./page01/NotFiles";

const App01 = () => {
    return (
        <div>
            <BrowserRouter>
                <>
                    <nav>
                        {/* <a> 대신 <Link> 사용 */}
                        <li>
                            <Link to="/">Home</Link>
                        </li>
                        <li>
                            <Link to="/about">About</Link>
                        </li>
                        <li>
                            <Link to="/ceo">Ceo</Link>
                        </li>
                        <li>
                            <Link to="/sub01">Sub01</Link>
                        </li>
                    </nav>

                    {/* 화면에 보이는 영역 */}
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/about" element={<About />} />
                        <Route path="/ceo" element={<Ceo />} />
                        <Route path="/sub01" element={<Sub01 />} />
                        <Route path="*" element={<NotFiles />} />
                    </Routes>
                </>
            </BrowserRouter>
        </div>
    );
};

export default App01;
