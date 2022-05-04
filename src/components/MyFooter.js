import React from "react";
import {Layout} from "antd";
const {Footer} = Layout;

export default class Index extends React.Component {
  render() {
    return (
      <Footer style={{ textAlign: 'center', color:'dimgray' }}>
        <hr style={{width: '100%'}}/>
        <p>联系我们</p>
        <p>地址：上海市闵行区东川路800号</p>
        <span>邮编：100050</span>
        <span style={{marginLeft: '15px'}}>电话：010-57099114</span>
        <hr style={{width: '30%'}}/>
        ©2022 Xxx All Rights Reserved
      </Footer>
    )
  }
}
