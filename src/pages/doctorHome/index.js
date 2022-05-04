import React from "react";
import MyHeader from '../../components/MyHeader';
import MyFooter from '../../components/MyFooter';
import {Layout} from "antd";
import './doctorHome.css';
import MyCalendar from "./calendar";
const {Content} = Layout;


const patients = [
  {
    date: '2022-2-11',
    time: '8:00',
    name: '患者1',
  },
  {
    date: '2022-2-11',
    time: '10:00',
    name: '患者2',
  },
  {
    date: '2022-2-12',
    time: '8:00',
    name: '患者3',
  },
  {
    date: '2022-2-12',
    time: '8:00',
    name: '患者4',
  }
]
const date = '2022-2-12'

export default class Index extends React.Component {
  render() {
    return (
      <Layout>
        <MyHeader/>
        <Content style={{padding: '30px 50px', marginTop: 64, height: "auto"}}>
          <div id={'title'}>
          <center><h >张文宏医生--排班信息</h></center>
          </div>
          <MyCalendar/>
        </Content>
        <MyFooter/>
      </Layout>
    )
  }
}
