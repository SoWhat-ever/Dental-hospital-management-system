import React from "react";
import {history} from 'umi';
import {Calendar} from "antd";
import moment from 'moment';
import {getOrderByDoctorAndTime} from "../../../services/RegistrationServices";
import {Select} from "antd";
import {Button} from "antd";
import '../registration.css'
import {message} from "antd";

const {Option}=Select;
export default class CalenderPage extends React.Component {
  constructor() {
    super();
    this.state = {
      orderList: [],
      selectValue: moment('2022-05-02'),
      dateList:[],
      selectDate:-1
    }
  }

  onSelect = value => {
    this.setState({
      selectDate:-1,
      selectValue: value
    });
    console.log(this.state.selectValue)
  };

  onPanelChange = value => {
    this.setState({selectValue: value});
  };

  handleChange = (value) =>{
    this.setState({
      selectDate:value
    })
    console.log(this.state.selectDate);
  }

  componentDidMount() {
    this.setState({
      orderList: getOrderByDoctorAndTime(history.location.state.doctorId)
    })
  }

  handleClick =()=>{
    // console.log(`you submit ${this.state.selectDate}`);
    if(this.state.selectDate!==-1){
      //加入registration表单 若当前医生当前时间段已经挂号 则不能挂号
      let order = {
        time: this.state.selectValue,
        state:'待就诊',
        dept:'口腔正畸科',
        doc:history.location.state.doctor
      }
      localStorage.setItem('order',  JSON.stringify(order));
      message.success('挂号成功');
      console.log(localStorage.getItem('order'));
    }
    else message.error('请选择时间')
  }
  selectView = () => {
    let select = [];
    this.state.orderList.forEach(element => {
      let dateymd = element.date.substring(0, 10);
      if (dateymd === this.state.selectValue.format('YYYY-MM-DD')) {
        select.push({
          sdate:element.date,
          sremain:element.remain
        })
      }
    })
    if (select.length === 0) return <div className={"order-select"}>当前时间无诊号</div>
    else return <div className={"order-select"}>
      <Select style={{width: 240}} onChange={this.handleChange}>
        {
          select.map((element,index)=>{
            return (
              <Option value={element.sdate} key={index}>{element.sdate}余量{element.sremain}</Option>
            )
          })
        }
      </Select>
      <Button onClick={this.handleClick}>预约</Button>
    </div>
  }


  render() {
    const {value} = this.state.selectValue;
    return (
      <div>
        <center>
          <h>请选择时间</h>
        </center>
        <div className="site-calendar-demo-card">
          <Calendar fullscreen={false} value={value} onSelect={this.onSelect} onPanelChange={this.onPanelChange}/>
        </div>
        {this.selectView()}
      </div>
    )
  }
}
