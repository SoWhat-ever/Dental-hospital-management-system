import React from "react";
import MyHeader from "../../components/MyHeader";
import MainPage from "../../components/MainPage";
import MyFooter from "../../components/MyFooter";
import {Layout, Input} from "antd";
import { AudioOutlined } from '@ant-design/icons';

const { Search } = Input;

export default class Index extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      searchVal:'',
    }
  }

  onSearch = (value) =>{
    this.setState({
      searchVal:value
    })
  }

  render() {
    return (
      <Layout>
        <MyHeader/>
        <Search
          addonBefore="https://"
          placeholder="input search text"
          allowClear
          onSearch={this.onSearch}
          style={{ width: 304 }}
        />

        <MyFooter/>
      </Layout>
    );

  }

}
