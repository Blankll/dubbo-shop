import React from "react";
import {Card, Form, Button, Col, Alert} from "react-bootstrap";
import "./Register.css"
import UserApi from "../../api/User";
class Register extends React.Component {
  state = {
    email: '',
    username: '',
    password: '',
    phone: '',
    errors: []
  };

  getCurrentUserInfo = () => ({
    email: this.state.email,
    username: this.state.username,
    password: this.state.password,
    phone: this.state.phone
  });

  submit = async (event) => {
    event.preventDefault();
    try {
      await UserApi.register(this.getCurrentUserInfo());
      this.props.history.push('/login')
    } catch (e) {
      this.setState({ errors: e.response.data.messages })
    }
  };

  handleChange = field => event => {
    this.setState({ [field]: event.target.value })
  };

  render() {
    const errors = this.state.errors;
    return(
      <Card body className="register-card">
        <h2>Sign Up</h2>
        {errors && errors.map((error, index) => (
          <Alert key={index} variant="danger">{ error }</Alert>)
        )}
        <Form onSubmit={this.submit}>
          <Form.Group>
            <Form.Row>
              <Form.Label column className="register-label">Email</Form.Label>
              <Col sm="10">
                <Form.Control type="email" onChange={this.handleChange("email")} className="input-item" placeholder="Email Address" />
              </Col>
            </Form.Row>
            <Form.Row>
              <Form.Label column className="register-label">Username</Form.Label>
              <Col sm="10">
                <Form.Control type="text" onChange={this.handleChange("username")} className="input-item" placeholder="Username" />
              </Col>
            </Form.Row>
            <Form.Row>
              <Form.Label column className="register-label">Password</Form.Label>
              <Col sm="10">
                <Form.Control type="password" onChange={this.handleChange("password")} className="input-item" placeholder="Password" />
              </Col>
            </Form.Row>
            <Form.Row>
              <Form.Label column className="register-label">Phone</Form.Label>
              <Col sm="10">
                <Form.Control type="text" onChange={this.handleChange("phone")} className="input-item" placeholder="Phone Number" />
              </Col>
            </Form.Row>
          </Form.Group>
          <Form.Row>
            <Form.Label column className="register-label"/>
            <Col sm="10">
              <Button variant="primary" size="lg" type="submit" block>REGISTER</Button>
            </Col>
          </Form.Row>
        </Form>
      </Card>
    )
  }
}

export default Register;