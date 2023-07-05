import React from "react";
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import Home from "./page03/Home";
import About from "./page03/About";
import Profile from "./page03/Profile";
import Front from "./page03/Front";

const data = [
    { title: "html", info: "This is HTML." },
    { title: "css", info: "This is CSS." },
    { title: "javascript", info: "This is JAVASCRIPT." },
    { title: "react", info: "This is REACT." },
    { title: "vue", info: "This is VUE." },
];

const App03 = () => {
    return (
        <BrowserRouter>
            <>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/about">About</Link>
                    </li>
                    <li>
                        <Link to="/profile">Profile</Link>
                    </li>

                    {/* ---------------------------------------------------- */}

                    <li>
                        <Link to="/front/html">html</Link>
                    </li>
                    <li>
                        <Link to="/front/css">css</Link>
                    </li>
                    <li>
                        <Link to="/front/javascript">javascript</Link>
                    </li>
                    <li>
                        <Link to="/front/react">react</Link>
                    </li>
                    <li>
                        <Link to="/front/vue">vue</Link>
                    </li>
                </ul>
            </>

            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/about" element={<About />} />
                <Route path="/profile" element={<Profile />} />
                <Route path="/front/:name" element={<Front data={data} />} />
                {/* :style 를 route path에 사용하면 useParams() 로 불러와 사용할
                수 있다. : 뒤에 나오는 부분이 params의 key 부분이 되어 :name 는
                name가 key가 되어 불러오고 있다. */}
            </Routes>
        </BrowserRouter>
    );
};

export default App03;
