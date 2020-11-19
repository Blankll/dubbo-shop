import React from "react";
import { Card, Form, Button } from "react-bootstrap";
import "./Login.css"
class Login extends React.Component {

  render() {
    return(
      <Card body className="login-card">
        <h2>Login</h2>
        <Form.Group>
          <Form.Control type="text" className="input-item" placeholder="Username" />
          <Form.Control type="password" className="input-item" placeholder="Password" />
          <Button variant="primary" size="lg" type="submit" block>Login</Button>
        </Form.Group>
      </Card>
    )
  }
}

export default Login;