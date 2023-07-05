import React from "react";

const Animal = ({ name, onInputName }) => {
    return (
        <div>
            <h2>Animal 컴포넌트</h2>
            <label>동물 이름을 입력하시오</label>
            <input type="text" value={name} onChange={onInputName} />
        </div>
    );
};

export default Animal;
