import React from "react";
import MyHeader from '../../components/MyHeader';
import MyFooter from '../../components/MyFooter';
import {Sider} from "./component/sider";
import PersonalInfo from "./component/personalnfo";
import Process from './component/process';
import Report from "./component/report";
import Guahao from "./component/guahao";
import {Layout} from "antd";
import './patient.css';
import {history} from "../../.umi/core/history";

const {Content} = Layout;

export default class Patient extends React.Component{



  render() {
    if (localStorage.getItem('user') == null) {
      history.push('/login');
      alert("请先登录");
      return null;
    }
    return(
      <Layout>
        <MyHeader/>
        <Content style={{padding: '0 50px', marginTop: 64, height: "auto"}}>
          <div>
          <div id={'sider'}>
            <Sider/>
          </div>
          <div id={'info'}>
           <PersonalInfo/>
            <Guahao/>
            <Process/>
            <Report/>
            <div style={{paddingLeft: '50px', paddingRight: '50px'}}>
              <center><h2>病历</h2></center>
              <p>市卫健委今早（28日）通报：2022年4月27日0—24时，新增本土新冠肺炎确诊病例1292（含既往无症状感染者转为确诊病例858例）和无症状
                感染者9330例，432例确诊病例和9140例无症状感染者在隔离管控中发现，其余在相关风险人群排查中发现。</p>
            </div>
          </div>
          </div>
        </Content>
        <MyFooter/>
      </Layout>
    )
  }
}
