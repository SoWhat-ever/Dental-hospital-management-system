import React from "react";
import {Card, List} from "antd";
import {history} from "../../../.umi/core/history";
import {getDept} from "../../../services/RegistrationServices";

export default class Deptmanager extends React.Component{
  constructor(props) {
    super(props);
    this.state={
      depts:[]
    }
  }

  componentDidMount() {
    this.setState({
      depts:getDept()
    })
  }

  render() {
    return (
      <div>
        <List
          grid={{gutter: 5, column: 1}}
          dataSource={this.state.depts}
          pagination={{
            onChange: page => {
              console.log(page);
            },
            pageSize: 5,
          }}

          renderItem={item => (
            <List.Item>
              <Card title={item.name}>
              </Card>
            </List.Item>
          )}
        />
      </div>
    );
  }
}
