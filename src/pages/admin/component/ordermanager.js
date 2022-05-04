import React from "react";
import {Button, Calendar, message} from "antd";
import {Select} from "antd";
import {getDept} from "../../../services/RegistrationServices";
import {getDoctorByDept} from "../../../services/RegistrationServices";
import {addOrder} from "../../../services/dataService";

const {Option} =Select

const order=[
  10,
  20,
  30,
  40,
  50
]

const time=[
  "2022-05-11 07:30:00",
  "2022-05-11 08:30:00",
  "2022-05-11 09:30:00",
  "2022-05-11 10:30:00",
  "2022-05-11 13:30:00",
  "2022-05-11 14:30:00",
  "2022-05-11 15:30:00",
  "2022-05-11 16:30:00",
  "2022-05-11 18:30:00",
  "2022-05-11 19:30:00",
]
export default class Ordermanager extends React.Component{
  constructor() {
    super();
    this.state={
      depts:[],
      doctors:[],
      selectDate:0,
      selectDept:0,
      selectDoctor:0,
      selectNum:0
    }
  }

  handleSubmitClick=()=>{
    message.success('发放诊号成功');
    let values = {
      name:this.state.selectDoctor,
      num:this.state.selectNum,
      date:this.state.selectDate

    }
    console.log(values);
    addOrder(values);

  }
  componentDidMount() {
    this.setState({
      depts:getDept()
    })
  }

  handleChangeDept=value=>{
    this.setState({
      selectDept:value,
      doctors:getDoctorByDept(value)
    })
  }

  handleChangeDoctor=value=>{
    console.log(value);
    this.setState({
      selectDoctor: value
    })
  }

  handleChangeDate=value=>{
    console.log(value);
    this.setState({
      selectDate: value
    })
  }

  handleChangeNum=value=>{
    this.setState({
      selectNum: value
    })
  }

  render() {
    return (
      <div className={"admin-content"}>
        <div>
          <Select style={{width: 180}} onChange={this.handleChangeDept}>
          {
            this.state.depts.map((element,index)=>{
              return (
                <Option value={element.name} key={index} >{element.name}</Option>
              )
            })
          }
        </Select>
          <Select style={{width: 180}} onChange={this.handleChangeDoctor}>
            {
              this.state.doctors.map((element,index)=>{
                return (
                  <Option value={element.name} key={index}>{element.name}</Option>
                )
              })
            }
          </Select>
          <Select style={{width: 180}} onChange={this.handleChangeDate}>
            {
              time.map((element,index)=>{
                return (
                  <Option value={element} key={index}>{element}</Option>
                )
              })
            }
          </Select>
          <Select style={{width: 180}} onChange={this.handleChangeNum}>
            {
              order.map((element,index)=>{
                return (
                  <Option value={element} key={index}>{element}</Option>
                )
              })
            }
          </Select>
          <Button onClick={this.handleSubmitClick}>
            发放诊号
          </Button>
        </div>
        <div>
          <br/>
          <center>当前诊号信息</center>
          <Calendar/>
        </div>
      </div>
    );
  }
}
