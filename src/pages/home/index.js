import React from "react";
import {Layout} from "antd";
import MyHeader from "../../components/MyHeader";
import MyFooter from "../../components/MyFooter";
import MainPage from "../../components/MainPage";

export default class Home extends React.Component {
  render() {
    return(
      <Layout>
        <MyHeader/>
        <MainPage/>
        <MyFooter/>
      </Layout>
    )
  }
}
