import React from "react";

const Name = ({ name, onInputName }) => {
    return (
        <>
            이름 <input type="text" value={name} onChange={onInputName} />
        </>
    );
};

export default Name;
