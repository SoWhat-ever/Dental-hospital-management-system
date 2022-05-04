import React, {useState} from "react";
import {Modal, Button} from 'antd';
import {Link} from 'umi';
import {Calendar, Badge} from 'antd';

function getListData(value) {
  let listData;
  switch (value.date()) {
    case 6:
      listData = [
        {type: 'warning', content: '8:00-8:30'},
        {type: 'success', content: '13:00-13:30'},
      ];
      break;
    case 8:
      listData = [
        {type: 'warning', content: '8:00-8:30'},
        {type: 'success', content: '13:00-13:30'},
      ];
      break;
    case 10:
      listData = [
        {type: 'warning', content: '8:00-8:30'},
        {type: 'success', content: '10:00-10:30'},
        {type: 'error', content: '13:00-13:30'},
      ];
      break;
    case 15:
      listData = [
        {type: 'warning', content: '8:00-8:30'},
        {type: 'success', content: '10:00-10:30'},
        {type: 'error', content: '13:00-13:30'},
      ];
      break;
    case 18:
      listData = [
        {type: 'warning', content: '8:00-8:30'},
        {type: 'success', content: '10:00-10:30'},
        {type: 'error', content: '13:00-13:30'},
      ];
      break;
    case 24:
      listData = [
        {type: 'warning', content: '8:00-8:30'},
        {type: 'success', content: '10:00-10:30'},
        {type: 'error', content: '13:00-13:30'},
      ];
      break;
    case 27:
      listData = [
        {type: 'warning', content: '8:00-8:30'},
        {type: 'success', content: '10:00-10:30'},
      ];
      break;
    default:
  }
  return listData || [];
}

function dateCellRender(value) {
  const listData = getListData(value);

  const [isModalVisible, setIsModalVisible] = useState(false);

  const showModal = () => {
    setIsModalVisible(true);
  };

  const handleOk = () => {
    setIsModalVisible(false);
  };

  const handleCancel = () => {
    setIsModalVisible(false);
  };
  return (
    <div>
      <ul className="events" onClick={showModal}>
        {listData.map(item => (
          <li key={item.content}>
            <Badge status={item.type} text={item.content}/>
          </li>
        ))}
      </ul>
      <Modal title="患者列表" visible={isModalVisible} onOk={handleOk} onCancel={handleCancel}>
        <p>
          <span> 8:00-8:30</span>
          <span className={'seperate'}> <Link to={'./doctorRecord'}>前往记录</Link></span>
          <span className={'seperate'}>患者一</span>
        </p>
        <p>
          <span> 10:00-10:30</span>
          <span className={'seperate'}> <Link to={'./doctorRecord'}>前往记录</Link></span>
          <span className={'seperate'}>患者二</span>
        </p>
        <p>
          <span> 13:00-13:30</span>
          <span className={'seperate'}> <Link to={'./doctorRecord'}>前往记录</Link></span>
          <span className={'seperate'}>患者三</span>
        </p>
      </Modal>
    </div>
  );
}


export default class MyCalendar extends React.Component {
  render() {
    return (
      <div>
        <Calendar dateCellRender={dateCellRender}/>
      </div>
    )
  }
}
