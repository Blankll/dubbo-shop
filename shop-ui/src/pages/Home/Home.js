import React from "react";
import goodApi from "../../api/Good";
import Good from "../../components/Good/Good";

class Home extends React.Component {
  state = {
    goods: []
  }
  async componentDidMount() {
    const resp = await goodApi.getAvailableGoods();
    this.setState({ goods: resp?.data });
  }
  render() {
    const goods = this.state.goods;
    return(
      <div>
        {goods?.map(good => (
          <Good key={good.id} {...good} />
        ))}
      </div>
    )
  }
}

export default Home;