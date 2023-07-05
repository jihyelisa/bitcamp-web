import React, { useRef, useState } from "react";
import styles from "../css/TodoForm.module.css";

const TodoForm = ({ onAdd }) => {
    const textRef = useRef();
    const [text, setText] = useState("");

    const onInput = (e) => {
        setText(e.target.value);
    };
    const onSubmit = (e) => {
        e.preventDefault();

        if (!text) return;
        onAdd(text);
        setText("");
        textRef.current.focus();
    };

    return (
        <div>
            <form className={styles.TodoForm} onSubmit={onSubmit}>
                <input
                    type="text"
                    placeholder="write a thing to do"
                    value={text}
                    onChange={onInput}
                    ref={textRef}
                />
                <button type="submit">Add</button>
            </form>
        </div>
    );
};

export default TodoForm;
