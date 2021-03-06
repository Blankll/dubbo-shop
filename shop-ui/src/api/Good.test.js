import axios from 'axios';
import  GoodApi from './Good'
jest.mock('axios');
jest.mock('../utils/config', () => { return { prefix: 'base.url.com' }});

describe('goodApi', () => {
  describe('getAvailableGoods', () => {
    it('make a get request to the items endpoint ', async  () => {
      axios.get.mockResolvedValue({ data: {}});
      await GoodApi.getAvailableGoods();
      expect(axios.get).toHaveBeenCalledWith('base.url.com/api/goods');
    });

    it('should not hide request error', async () => {
      axios.get.mockRejectedValue(new Error());
      await expect(GoodApi.getAvailableGoods()).rejects.toThrow();
    });
  });
});