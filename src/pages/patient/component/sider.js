import {AppstoreOutlined, MailOutlined, ProfileOutlined, SettingOutlined} from "@ant-design/icons";
import {Menu} from "antd";
import React from "react";

function getItem(label, key, icon, children, type) {
  return {
    key,
    icon,
    children,
    label,
    type,
  };
}

const items = [
  getItem( '个人信息',  'sub1', <SettingOutlined /> ),
  getItem('挂号信息', 'sub2', <MailOutlined />, [
    getItem('待就诊', '1', ),
    getItem('已完成', '2', ),
  ]),
  getItem('诊断情况', 'sub3', <AppstoreOutlined />, [
    getItem('诊断流程', '5'),
    getItem('病历', '6'),
    getItem('注意事项', '7'),
  ]),
  getItem('报告查询', 'sub4', <ProfileOutlined />, [
    getItem('未出具', '9'),
    getItem('待取出', '10'),
    getItem('已取出', '11'),

  ]),
];

export const Sider = () => {
  const onClick = (e) => {
    console.log('click ', e);
  };

  return (
    <Menu
      onClick={onClick}
      style={{
        width: 256,
        fontWeight: 'bold',
        fontSize: 'medium'
      }}
      defaultSelectedKeys={['sub1']}
      defaultOpenKeys={['sub1','sub2','sub3','sub4']}
      mode="inline"
      items={items}
    />
  );
};
