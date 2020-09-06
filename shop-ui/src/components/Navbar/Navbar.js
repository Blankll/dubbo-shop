import React from "react";
import { Link } from 'react-router-dom'
import logo from '../../assets/logo.png'
import './Navbar.css'

class Navbar extends React.Component {

  render() {
    return (
      <div className="navbar">
        <span>
          <img
            className="navbar__logo"
            width="20px"
            src={logo}
            alt="logo.png"
            />
            <span className="navbar__logo-name">You Buy</span>
        </span>
        <ul className="navbar__links">
          <li><Link to="/">Home</Link></li>
          <li><Link to="/login">Sign In</Link></li>
          <li><Link to="/register">Sign Up</Link></li>
        </ul>
      </div>
    )
  }
}

export default Navbar;