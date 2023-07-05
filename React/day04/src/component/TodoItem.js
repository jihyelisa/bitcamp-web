import React from "react";

const TodoItem = ({ item, onDelete }) => {
    const { seq, text } = item;

    return (
        <li key={seq}>
            {seq} : {text}
            <button onClick={() => onDelete(seq)}>X</button>
        </li>
    );
};

export default TodoItem;
