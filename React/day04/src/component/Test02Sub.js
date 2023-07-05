import React, { useEffect, useState } from "react";

const Test02Sub = () => {
    const [x, setX] = useState(0);
    const [y, setY] = useState(0);

    const onMove = (e) => {
        setX(e.clientX);
        setY(e.clientY);
    };

    useEffect(() => {
        console.log("useeffect");
        window.addEventListener("mousemove", onMove);
        // window.addEventListener("click", onMove);

        return () => {
            console.log("cleanup");
            window.removeEventListener("mousemove", onMove);
        };
    }, []);
    // []를 비우면
    // 컴포넌트가 나타날 때 한 번 실행
    // 컴포넌트 사라질 때 cleanup 함수 호출

    return (
        <div>
            <h2>마우스 좌표</h2>
            <div>
                <h3>
                    X축: {x}, Y축: {y}
                </h3>
            </div>
        </div>
    );
};

export default Test02Sub;
