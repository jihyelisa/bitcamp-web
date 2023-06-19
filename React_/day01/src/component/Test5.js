import React from "react";
import Test5Sub from "./Test5Sub.js";

const Test5 = () => {
    return (
        <div>
            <Test5Sub
                name="홍길동"
                age={19}
                addr="서울"
                tel="010-1234-5678"
                color="tomato"
                bgcolor="pink"
                done={true}
            />
            <br />
            <Test5Sub
                name="코난"
                addr="부산"
                color="skyblue"
                bgcolor="hotpink"
            />
        </div>
    );
};

export default Test5;
