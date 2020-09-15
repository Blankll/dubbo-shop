import React from "react";
import { Card, Button } from "react-bootstrap";
import './good.css'
export default function Good (props) {
  return (
    <Card body className="item">
      <div className="item__name">{props.name}</div>
      <div className="item__price">￥: {props.price}</div>
      <div className="item__quantity">In stock: {props.quantity}</div>
      <div className="item__desc">{props.desc}</div>
      <Button variant="outline-primary" className="item__button">RESERVE</Button>
    </Card>
  )
}