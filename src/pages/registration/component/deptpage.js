import React from "react";
import {getDept} from "../../../services/RegistrationServices";
import {List, Card} from "antd";
import {history} from "../../../.umi/core/history";

export default class DeptPage extends React.Component {
  constructor() {
    super();
    this.state = {
      depts: []
    };
  };

  componentDidMount() {
    this.setState({
      depts: getDept()
    })
  }

  render() {
    return (
      <div>
        <center>
          <h>请选择科室</h>
        </center>
        <List
          grid={{gutter: 5, column: 4}}
          dataSource={this.state.depts}
          pagination={{
            onChange: page => {
              console.log(page);
            },
            pageSize: 16,
          }}

          renderItem={item => (
            <List.Item>
              <Card title={item.name}><button onClick={()=>{history.push({
                pathname: '/registration/doctor',
                state: {
                  dept: item.name
                },
              })}}>请选择医生</button></Card>
            </List.Item>
          )}
        />
      </div>

    )
  }
}
