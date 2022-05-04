import React from "react";
import MyHeader from '../../components/MyHeader';
import MyFooter from '../../components/MyFooter';
import {Layout} from "antd";

const {Content} = Layout;

export default class Index extends React.Component{
  render() {
    return(
      <Layout>
        <MyHeader/>
        <Content style={{padding: '0 50px', marginTop: 64, height: "auto"}}>
          <div id={'register'}>
            1234
          </div>
        </Content>
        <MyFooter/>
      </Layout>
    )
  }
}
