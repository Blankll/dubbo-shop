import React from "react";
import Home from "./Home";
import { shallow } from 'enzyme'
import goodApi from "../../api/Good";
import mockGoods from '../../mock/goods'
import Good from "../../components/Good/Good";
jest.mock('../../api/good')
describe('<Home />', () => {
  const flushPromises = () => new Promise(setImmediate);
  it('should fetch all goods in home page', async () => {
    shallow(<Home />);
    await flushPromises();

    expect(goodApi.getAvailableGoods).toHaveBeenCalledTimes(1);
  });
  it('should render correct number of items in home page', async () => {
    goodApi.getAvailableGoods.mockResolvedValue(mockGoods);
    const wrapper = shallow(<Home />);
    await flushPromises();
    wrapper.update();

    expect(wrapper.find(Good)).toHaveLength(2);
  });
});