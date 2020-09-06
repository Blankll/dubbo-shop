import React from 'react';
import { mount, shallow } from 'enzyme';
import App from './App';
import Navbar from "./components/Navbar/Navbar";

test('renders learn react link', () => {
  const wrapper = mount(<App />);

  expect(wrapper.find(Navbar)).toHaveLength(1);
});
