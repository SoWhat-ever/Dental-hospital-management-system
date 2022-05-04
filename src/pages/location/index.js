import React, {Component, useState} from 'react'
import {Map,Marker} from 'react-amap'
import MyHeader from "../../components/MyHeader";
import {Layout} from "antd";
const mapKey = '037d87314d1533c3c626da62d704875b' //需要自己去高德官网上去申请
class Address extends Component {
  constructor (props) {
    super (props)
    this.state = {
    }
  }
  render(){

    return (
      <Layout>
        <MyHeader/>
          <div style={{width: '100%', height: '760px'}}>

            <Map amapkey={mapKey}
                 zoom={15}
                  center={[121.42509,31.02188]}>
              <Marker title="我院地址" position={[121.42509,31.02188]} />
            </Map>
          </div>

      </Layout>
    )
  }
}

export default Address
