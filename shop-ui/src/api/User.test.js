import axios from 'axios';
import UserApi from './User'
jest.mock('axios');
jest.mock('../utils/config', () => { return { prefix: 'base.url.com' }});

describe('UserApi', () => {
  const user = {
    email: 'lisheng@ls.com',
    username: 'blank',
    password: '123',
    phone: '1111111111'
  }
  describe('register', () => {
    it('register new a new user ', async  () => {
      axios.post.mockResolvedValue({ data: {}});
      await UserApi.register(user);
      expect(axios.post).toHaveBeenCalledWith('base.url.com/api/user', user);
    });

    it('should not hide request error', async () => {
      axios.post.mockRejectedValue(new Error());
      await expect(UserApi.register(user)).rejects.toThrow();
    });
  });
});