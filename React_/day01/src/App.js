import React from "react";
import Dog from "./component/Dog.js";
import Test1 from "./component/Test1.js";
import Test2 from "./component/Test2.js";
import Test3 from "./component/Test3.js";
import Test4 from "./component/Test4.js";
import Test5 from "./component/Test5.js";

const App = () => {
    // 이 구역은 스크립트 주석

    return (
        <div>
            {/* 최상단에서 반드시 <div>로 감싸주어야 함 */}
            <Dog />
            <hr />
            <Dog />
            <hr />
            <Test1 />
            <hr />
            <Test2 />
            <hr />
            <Test3 />
            <hr />
            <Test4 />
            <hr />
            <Test5 />
            <hr />
        </div>
    );
};

export default App;
// App 안의 return 안의 내용이 내보내짐
