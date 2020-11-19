import React from "react";
import { shallow } from 'enzyme';
import Good from "./Good";

describe('<Good />', () => {
  const props = {
    id: 2,
    name: "IPhone 4S",
    price: 5299,
    desc: "IPhone 4S, new generation smart phone, with IOS 6 system.",
    quantity: 900,
    created: "2019-01-31 21:47:18",
    updated: "2019-01-31 21:47:18"
  }
  it('should render a good item',  () => {
    const wrapper = shallow(<Good {...props} />);

    expect(wrapper.find('.item').exists()).toBe(true);
    expect(wrapper.find('.item__quantity').text()).toEqual("In stock: 900");
  });
});