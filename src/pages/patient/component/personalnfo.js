import React from "react";
import {Descriptions} from "antd";

export default class PersonalInfo extends React.Component{
  render() {
    return(
      <div>
        <center>
          <h2 className={'title'}>个人信息</h2>
        </center>
        <Descriptions bordered={'true'}>
          <Descriptions.Item label="姓名">{JSON.parse(localStorage.getItem('user')).name}</Descriptions.Item>
          <Descriptions.Item label="性别">{JSON.parse(localStorage.getItem('user')).sex}</Descriptions.Item>
          <Descriptions.Item label="年龄">{JSON.parse(localStorage.getItem('user')).age}</Descriptions.Item>
          <Descriptions.Item label="出生日期">1994-04-24 </Descriptions.Item>
          <Descriptions.Item label="联系方式" span={2}>
            15304141234
          </Descriptions.Item>
        </Descriptions>
      </div>
    )
  }
}
