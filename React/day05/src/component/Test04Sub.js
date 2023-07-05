import React, { useMemo } from "react";

const getColor = (color) => {
    console.log("getColor");

    switch (color) {
        case "hotpink":
            return "hotpink";
        case "magenta":
            return "magenta";
        case "skyblue":
            return "skyblue";
        case "tomato":
            return "tomato";
    }
};

const getFood = (food) => {
    console.log("getFood");

    switch (food) {
        case "hamburger":
            return "hamburger";
        case "steak":
            return "steak";
        case "fried chicken":
            return "fried chicken";
        case "ramen":
            return "ramen";
    }
};

const Test04Sub = ({ color, food }) => {
    // 둘 중 하나만 선택해도 둘다 로그 찍힘
    // = 전체를 다시 렌더링하며 불필요한 실행 발생
    // const colorInfo = getColor(color);
    // const foodInfo = getFood(food);

    // 변경된 부분만 실행
    const colorInfo = useMemo(() => {
        return getColor(color);
    }, [color]);
    const foodInfo = useMemo(() => {
        return getFood(food);
    }, [food]);

    return (
        <div>
            <h3>Your favorite color: {color}</h3>
            <h4>You love {colorInfo}!</h4>

            <h3>Your favorite food: {food}</h3>
            <h4>You love {foodInfo}!</h4>
        </div>
    );
};

export default Test04Sub;
