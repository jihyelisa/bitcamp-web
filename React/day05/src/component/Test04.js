import React, { useState } from "react";
import Test04Sub from "./Test04Sub";

const Test04 = () => {
    const [color, setColor] = useState("");
    const [food, setFood] = useState("");

    const onColor = (e) => {
        const { value } = e.target;
        setColor(value);
    };
    const onFood = (e) => {
        const { value } = e.target;
        setFood(value);
    };

    return (
        <div style={{ margin: 30 }}>
            <h2>What's your favorite color?</h2>
            <div>
                <input type="text" value={color} onChange={onColor} />
                <p>select: hotpink, magenta, skyblue, tomato</p>
            </div>
            <hr />

            <h2>What's your favorite food?</h2>
            <div>
                <p>
                    <input
                        type="radio"
                        name="food"
                        value="hamburger"
                        onChange={onFood}
                    />
                    <label>hamburger</label>
                </p>
                <p>
                    <input
                        type="radio"
                        name="food"
                        value="steak"
                        onChange={onFood}
                    />
                    <label>steak</label>
                </p>
                <p>
                    <input
                        type="radio"
                        name="food"
                        value="fried chicken"
                        onChange={onFood}
                    />
                    <label>fried chicken</label>
                </p>
                <p>
                    <input
                        type="radio"
                        name="food"
                        value="ramen"
                        onChange={onFood}
                    />
                    <label>ramen</label>
                </p>
            </div>

            <hr />
            <Test04Sub color={color} food={food} />
        </div>
    );
};

export default Test04;
