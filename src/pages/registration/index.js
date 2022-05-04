import React from "react";
import MyHeader from '../../components/MyHeader';
import MyFooter from '../../components/MyFooter';
import {Layout} from "antd"
import DeptPage from "./component/deptpage";
import DocPage from "./component/docpage";
import{ Breadcrumb} from "antd";
import './registration.css'

import { HashRouter, Route, Routes, Link, useLocation } from 'react-router-dom';
import {history} from "../../.umi/core/history";

const {Content} = Layout;
export default class Index extends React.Component{
  render() {
    if (localStorage.getItem('user') == null) {
      history.push('/login');
      alert("请先登录");
      return null;
    }
    return (
      <Layout>
        <MyHeader/>
        <Content style={{padding: '0 50px', marginTop: 64, height: "auto"}}>
          <div className={'regcontent'}>
            <DeptPage/>
          </div>
        </Content>
        <MyFooter/>
      </Layout>
    );
  }
}
