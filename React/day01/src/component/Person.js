import React from "react";

const Person = ({ name, age }) => {
    return (
        <div>
            <p>
                나의 이름은 {name}이고, 나이는 {age}세입니다.
            </p>
        </div>
    );
};

export default Person;
