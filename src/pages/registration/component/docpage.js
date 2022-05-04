import React from "react";
import {Card, List} from "antd";
import {getDoctorByDept} from "../../../services/RegistrationServices";
import {history} from 'umi';

export default class DocPage extends React.Component {
  constructor() {
    super();
    this.state = {
      doctors: [],
    };
  };

  componentDidMount() {
    this.setState({
      doctors: getDoctorByDept(history.location.state.dept)
    })
  }

  render() {
    return (
      <div>
        <center>
          <h>请选择医生</h>
        </center>
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
              <Card title={item.name}>
                <button onClick={() => {
                  history.push({
                    pathname: '/registration/doctor/calender',
                    state: {
                      doctor: item.name,
                      doctorId:item.id,
                    }
                  })
                }}>选择时间
                </button>
              </Card>
            </List.Item>
          )}
        />
      </div>

    )
  }
}
