import React from "react";

export default function Good (props) {
  return (
    <div className="item">
      <div className="item__name">{props.name}</div>
      <div className="item__price">￥: {props.price}</div>
      <div className="item__desc">{props.desc}</div>
      <div className="item__quantity">In stock: {props.quantity}</div>
    </div>
  )
}