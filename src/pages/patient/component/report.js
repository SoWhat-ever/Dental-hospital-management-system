import React from "react";
import {Table} from "antd";

const columns = [
  {
    title: '报告名称',
    dataIndex: 'name',
  },
  {
    title: '科室',
    dataIndex: 'depart',
  },
  {
    title: '日期',
    dataIndex: 'date',
  },
  {
    title: '状态',
    dataIndex: 'state',
    filters: [
      {
        text: '未出具',
        value: '未出具',
      },
      {
        text: '待取出',
        value: '待取出',
      },
      {
        text: '已取出',
        value: '已取出',
      }
    ],
    onFilter: (value, record) => record.state.indexOf(value) === 0,
  },
];

const data = [
  {
    key: '1',
    name: '报告一',
    depart: '口腔科',
    date: '2022-3-11',
    state: '已取出'
  },
  {
    key: '2',
    name: '报告二',
    depart: '牙周科',
    date: '2022-3-16',
    state: '待取出'
  },
  {
    key: '3',
    name: '报告三',
    depart: '正畸科',
    date: '2022-4-11',
    state: '未出具'
  },
];

function onChange(pagination, filters, sorter, extra) {
  console.log('params', pagination, filters, sorter, extra);
}
export default class Report extends React.Component{
  render() {
    return(
      <div style={{marginTop: '50px'}}>
        <center>
          <h2>报告查询</h2>
        </center>
        {localStorage.getItem('report') == null?
          <center>
            <h4>无</h4>
          </center>:
          <Table columns={columns} dataSource={data} onChange={onChange}/>
        }
      </div>
    )
  }
}
