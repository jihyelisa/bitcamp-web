import React, { useState } from "react";

const Test03 = () => {
    const [name, setName] = useState("홍길동");
    const [age, setAge] = useState(25);
    const [color, setColor] = useState("cyan");

    const onName = () => {
        setName("코난");
    };
    const onAge = (num) => {
        setAge(num);
    };
    const onColor = () => {
        setColor("yellow");
    };

    return (
        <div>
            <h2 style={{ background: color }}>
                이름: {name} / 나이: {age}
            </h2>
            <p>
                <button onClick={onName}>코난으로 이름 변경</button>
                <button onClick={() => onAge(30)}>30으로 나이 변경</button>
                <button onClick={() => onColor()}>노란색으로 변경</button>
            </p>
        </div>
    );
};

export default Test03;

/*
Hook ?

https://ko.reactjs.org/docs/hooks-state.html

Hook은 React 16.8버전에 새로 추가되었습니다.
Hook은 클래스 컴포넌트를 작성하지 않아도 state와 같은 특징들을 사용할 수 있습니다.

Hook의 개요

함수형 컴포넌트는 렌더링할때마다 내부의 것들을 기억하지 못한다.
다시 생성, 초기화 해야한다. (변수, 함수 등)

내부의 것들을 유지하기 위해서 hook이 등장했다 - useXXX

useState
- 값이 유동으로 변할 때
- const [상태데이터, 상태데이터의 값을 변경해주는 함수] = React.useState(초기값);
*/
