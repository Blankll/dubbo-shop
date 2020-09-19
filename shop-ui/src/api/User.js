import axios from 'axios';
import config from '../utils/config'

const UserApi = {
  register: async user => {
    let formData = new FormData();
    for (let key in user) {
      formData.append(key, user[key])
    }
    const resp = await axios.post(`${config.prefix}/api/user/register`, formData);

    return resp.data;
  }
}

export default UserApi;