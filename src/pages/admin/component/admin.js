import {AppstoreOutlined, SolutionOutlined, UserOutlined,FieldTimeOutlined} from "@ant-design/icons";
import React from "react";
import {Menu} from "antd";
import Deptmanager from "./deptmanager"
import Doctormanager from "./doctormanager";
import Ordermanager from "./ordermanager";
import Arrangemanager from "./arrangemanager";
export default class Admin extends React.Component {
  constructor() {
    super();
    this.state = {
      current: "order",
    };
  }

  handleClick(e) {
    this.setState({current: e.key});
  }

  contentView=()=>{
    switch (this.state.current){
      case 'order':
        return <Ordermanager/>
      case 'doctor':
        return <Doctormanager/>
      case 'department':
        return <Deptmanager/>
      case 'arrangement':
        return <Arrangemanager/>
    }
  }
  render() {
    return (
      <div>
        <Menu mode="horizontal" selectedKeys={[this.state.current]} onClick={this.handleClick.bind(this)}>
          <Menu.Item key="order">
            <SolutionOutlined/>诊号管理
          </Menu.Item>
          <Menu.Item key="doctor">
            <UserOutlined/>医生管理
          </Menu.Item>
          <Menu.Item key="department">
            <AppstoreOutlined/>科室管理
          </Menu.Item>
          {/*<Menu.Item key="arrangement">*/}
          {/*  <FieldTimeOutlined/>排班管理*/}
          {/*</Menu.Item>*/}
        </Menu>
        {this.contentView()}
      </div>

    );
  };

}
