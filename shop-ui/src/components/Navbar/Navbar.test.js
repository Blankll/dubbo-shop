import React from "react";
import { mount, shallow } from 'enzyme';
import Navbar from './Navbar';


describe('<Navbar />', () => {
  it('should render navbar logo', () => {
    const wrapper = shallow(<Navbar />);
    expect(wrapper.find('.navbar__logo')).toHaveLength(1);
  });
  it('should render navbar logo name', () => {
    const wrapper = shallow(<Navbar />);
    expect(wrapper.find('.navbar__logo-name').text()).toEqual('You Buy')
  });
  it('should render navbar links', () => {
    const wrapper = shallow(<Navbar />);
    expect(wrapper.exists('Link')).toEqual(true);
  });
})