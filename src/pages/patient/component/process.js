import React from "react";
import {Timeline} from "antd";
import {SmileOutlined} from "@ant-design/icons";

export default class Process extends React.Component{
  render() {
    return(
      <div style={{paddingLeft: '20px'}}>
        <center><h2>就诊流程</h2></center>

          <Timeline>
            <Timeline.Item color={localStorage.getItem('order') === null ? "grey":"green"}>挂号成功 2022-04-01</Timeline.Item>
            <Timeline.Item color="gray">第一次就诊 202-04-02</Timeline.Item>
            <Timeline.Item color="gray">
              <p>治疗病情</p>
              <p>预约第一次复诊 2015-09-01</p>
            </Timeline.Item>
            <Timeline.Item color="gray">
              <p>复诊完成</p>
              <p>支付缴费</p>
            </Timeline.Item>

          </Timeline>

      </div>
    )
  }
}
