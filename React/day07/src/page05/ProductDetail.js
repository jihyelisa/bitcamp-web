import React from "react";
import { useNavigate, useParams } from "react-router-dom";
import data from "./data";

const ProductDetail = () => {
    const navigate = useNavigate();
    const { productId } = useParams();
    const item = data.find((item) => item.id === productId);
    const { name, description, photo, price } = item;

    const onHome = () => {
        navigate("/");
    };
    const onList = () => {
        navigate("/productList");
    };

    return (
        <div className="item">
            <h2>Details</h2>
            <h3>
                product: {name} / price: {price}
            </h3>
            <p>
                <img src={photo} alt={name} />
            </p>
            <p>description: {description}</p>

            <button onClick={onHome}>home</button>
            <button onClick={onList}>list</button>
        </div>
    );
};

export default ProductDetail;
