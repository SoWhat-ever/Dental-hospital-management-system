import React from "react";
import MyHeader from "../../components/MyHeader";
import MyFooter from "../../components/MyFooter";
import Admin from "./component/admin";
import DeptPage from "../registration/component/deptpage";
import {Layout} from "antd";
import './admin.css'


const {Content} = Layout;
export default class Index extends React.Component{


  render() {

    return (
      <Layout>
        <MyHeader/>
        <Content style={{padding: '0 50px', marginTop: 64, height: "auto"}}>
          <div className={'admin'}>
            <Admin/>
          </div>
        </Content>
        <MyFooter/>
      </Layout>
    );
  }
}

