import React from "react";
import {Breadcrumb, Col, Layout, Row} from "antd";
import {EditFilled, HomeFilled, ToolFilled } from "@ant-design/icons";
import {Link} from 'umi';
import './header.css';

const {Header} = Layout;

export default class Index extends React.Component {
  handleLogout = () => {
    localStorage.removeItem('user');
    localStorage.removeItem('userType');
    localStorage.removeItem('order');
  }


  render() {
    return (
      <Header id={'myHeader'}>
        {/*<Breadcrumb style={{margin: '16px 0'}}>*/}
        {/*  <Breadcrumb.Item href="">*/}
        {/*    ><HomeOutlined/><span>Home</span>*/}
        {/*  </Breadcrumb.Item>*/}
        {/*</Breadcrumb>*/}
        <div id={'Logo'}>
          <Link to={'/'}>
            <div style={{width: "auto", float: 'left'}}>
              <img id={'logo'} src={require('../asserts/MainImg/icon_home.png')} alt={""}/>
              <h id={'name'}>上海市东川路牙科医院</h>
            </div>
          </Link>

          <div style={{float: 'right'}} id={'headBar'}>
            <ul id={'myUl'}>
              <li>
                辅助功能 <ToolFilled style={{marginLeft: '10px'}}/>
                <ul id={'drop'}>
                  <li>
                    功能1
                  </li>
                  <li>
                    功能1
                  </li>
                  <li>
                    功能1
                  </li>
                </ul>
              </li>

              {localStorage.getItem('user') == null ?
                <li>
                  <Link to={'/login'}>
                    <div className={'Div'}>
                      登录<HomeFilled style={{marginLeft: '10px'}}/>
                    </div>
                  </Link>
                </li>:
                <li>
                  <Link to={'/'} onClick={()=>this.handleLogout()}>
                    <div className={'Div'}>
                      退出登录<EditFilled style={{marginLeft: '10px'}}/>
                    </div>
                  </Link>
                </li>}

            </ul>
          </div>
        </div>

      </Header>

    )
  }
}
