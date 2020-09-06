import React from 'react';
import { Route, Switch } from 'react-router-dom'
import { ROUTERS } from "./router";
import './App.css';
import Navbar from "./components/Navbar/Navbar";

function App() {
  const getRouters = () => {
    return ROUTERS.map((route, index) => {
      const props = {
        path: route.path,
        exact: route.exact,
        component: route.component
      };
      return <Route key={index} {...props} />
    });
  }
  return (
    <div className="App">
      <Navbar />
      <Switch>{getRouters()}</Switch>
    </div>
  );
}

export default App;
