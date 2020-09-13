import axios from 'axios';
import config from '../utils/config'

const goodApi = {
  getAvailableGoods: async () => {
    const resp = await axios.get(`${config.prefix}/api/goods`);

    return resp.data;
  }
}

export default goodApi;