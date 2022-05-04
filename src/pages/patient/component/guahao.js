import React from "react";
import { Card, Col, Row } from 'antd';
import './guahao.css';

export default class Guahao extends React.Component{
  render() {
    return(
      <div className="wrapper">
        <center><h2>挂号信息</h2></center>
        {localStorage.getItem('order') === null?
          <center><h4>无</h4></center>:
          <Row gutter={16}>
            <Col span={8}>
              <Card title="2022年5月4日" bordered={false}>
                <div className={'numberCard'}>
                  时间：
                  {JSON.parse(localStorage.getItem('order')).time}
                  <br/>
                  诊号状态：<span className={'stateNofinish'}>{JSON.parse(localStorage.getItem('order')).state}</span>
                  <br/>
                  科室：{JSON.parse(localStorage.getItem('order')).dept}
                  <br/>
                  医生：{JSON.parse(localStorage.getItem('order')).doc}
                </div>
              </Card>
            </Col>

          </Row>
        }
      </div>
    )
  }
}
