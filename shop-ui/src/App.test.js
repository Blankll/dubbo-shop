import React from 'react';
import { mount, shallow } from 'enzyme';
import { MemoryRouter } from 'react-router-dom'
import App from './App';
import Navbar from "./components/Navbar/Navbar";
import Home from "./pages/Home/Home";

describe('router should redirect to correct path', () => {
  test('default path should redirect to homepage', () => {
    const wrapper = mount(
      <MemoryRouter>
        <App />
      </MemoryRouter>
    );
    expect(wrapper.find(Home)).toHaveLength(1);
  })
  test('renders render navbar', () => {
    const wrapper = mount(
      <MemoryRouter>
        <App />
      </MemoryRouter>
    );
    expect(wrapper.find(Navbar)).toHaveLength(1);
  });
});

