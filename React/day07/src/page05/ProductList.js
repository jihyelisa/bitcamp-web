import React from "react";
import data from "./data";
import { Link } from "react-router-dom";

const ProductList = () => {
    return (
        <div className="products">
            <h2>People Abroad</h2>
            <div>
                {data.map((item) => (
                    <article key={item.id}>
                        <Link to={`/productList/${item.id}`}>
                            <h3>{item.name}</h3>
                            <p>
                                <img src={item.photo} alt={item.name} />
                            </p>
                        </Link>
                    </article>
                ))}
            </div>
        </div>
    );
};

export default ProductList;
