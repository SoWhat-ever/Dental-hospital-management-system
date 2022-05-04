import React from "react";
import {getDoctor} from "../../../services/RegistrationServices";
import {Card, List} from "antd";
import {history} from "../../../.umi/core/history";
import '../admin.css'

const {Meta} = Card
export default class Doctormanager extends React.Component {
  constructor() {
    super();
    this.state = {
      doctors: [],
    };
  };

  componentDidMount() {
    this.setState({
      doctors: getDoctor()
    })
    console.log(this.state.doctors);
  }

  render() {
    return (
      <div className={"admin-content"}>
        <List
          grid={{gutter: 5, column: 4}}
          dataSource={this.state.doctors}
          pagination={{
            onChange: page => {
              console.log(page);
            },
            pageSize: 16,
          }}

          renderItem={item => (
            <List.Item>
              <Card
                hoverable
                style={{width: 240}}
                cover={<img alt="doctor" src={item.img} width={"100px"} height={"300px"}/>}>
                <Meta title={item.name} description={item.dept}/>
              </Card>
            </List.Item>
          )}
        />
      </div>
    );
  }
}
