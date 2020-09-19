
import Home from "./pages/Home/Home";
import Login from "./pages/Login/Login"
import Register from "./pages/Register/Register";
export const ROUTERS = [
  {
    path: '/',
    exact: true,
    component: Home,
    auth: []
  },
  {
    path: '/login',
    exact: true,
    component: Login,
    auth: []
  },
  {
    path: '/register',
    exact: true,
    component: Register,
    auth: []
  }
]