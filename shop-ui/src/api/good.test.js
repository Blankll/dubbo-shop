import axios from 'axios';
import goodApi from './good'
jest.mock('axios');
jest.mock('../utils/config', () => { return { prefix: 'base.url.com' }});

describe('goodApi', () => {
  describe('getAvailableGoods', () => {
    it('make a get request to the items endpoint ', async  () => {
      axios.get.mockResolvedValue({ data: {}});
      await goodApi.getAvailableGoods();
      expect(axios.get).toHaveBeenCalledWith('base.url.com/good');
    });

    it('should not hide request error', async () => {
      axios.get.mockRejectedValue(new Error());
      await expect(goodApi.getAvailableGoods()).rejects.toThrow();
    });
  });
});