import React from "react";
import MyHeader from '../../../components/MyHeader';
import MyFooter from '../../../components/MyFooter';
import {Layout} from "antd"
import DeptPage from "../component/deptpage";
import DocPage from "../component/docpage";
import{ Breadcrumb} from "antd";
import '../registration.css'

import { HashRouter, Route, Routes, Link, useLocation } from 'react-router-dom';

const {Content} = Layout;

export default class Index extends React.Component {
  render() {
    return (
      <Layout>
        <MyHeader/>
        <Content style={{padding: '0 50px', marginTop: 64, height: "auto"}}>
          <div className={'regcontent'}>
            <DocPage/>
          </div>
        </Content>
        <MyFooter/>
      </Layout>
    )
  }
}
