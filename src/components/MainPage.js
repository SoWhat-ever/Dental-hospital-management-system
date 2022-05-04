import React from "react";
import {Layout, BackTop} from 'antd';
import {Card, Col, Row} from 'antd';
import {RightOutlined} from '@ant-design/icons';
import {Link} from 'umi';

import './MainPage.css';

const {Content} = Layout;

class ShowPic extends React.Component {
  render() {
    return (
      <div id={'showPic'}>
        <img id={'mainPage'} src={require('../asserts/MainImg/homepage.jpg')} alt={""}/>
      </div>
    )
  }
}

class Guide extends React.Component {
  render() {
    return (
      <div id={'Guide'}>
        <p id={'guideTitle'}>就医指南</p>
        <div className="site-card-wrapper">
          <Row gutter={16}>
            <Col span={6}>
              <Link to={'/patient'}>
                <Card title="信息查询" bordered={false} hoverable={true}>
                  <img className={'funcImg'} src={require('../asserts/MainImg/func_1.png')} alt={""}/>
                  <span className={'funcWord'}>查询个人信息</span>
                </Card>
              </Link>
            </Col>
            <Col span={6}>
              <Link to={'/registration'}>
                <Card title="挂号预约" bordered={false} hoverable={true}>
                  <img className={'funcImg'} src={require('../asserts/MainImg/func_2.png')} alt={""}/>
                  <span className={'funcWord'}>网上预约挂号</span>
                </Card>
              </Link>
            </Col>
            <Col span={6}>
              <Link to={'/location'}>
                <Card title="来院路线" bordered={false} hoverable={true}>
                  <img className={'funcImg'} src={require('../asserts/MainImg/func_3.png')} alt={""}/>
                  <span className={'funcWord'}>线上来院导航</span>
                </Card>
              </Link>
            </Col>
            <Col span={6}>
              <Link to={'/question'}>
                <Card title="常见问题" bordered={false} hoverable={true}>
                  <img className={'funcImg'} src={require('../asserts/MainImg/func_4.png')} alt={""}/>
                  <span className={'funcWord'}>常见问题解答</span>
                </Card>
              </Link>
            </Col>
          </Row>
        </div>
      </div>
    )
  }
}

class Depart extends React.Component {
  render() {
    return (
      <div id={'Departs'}>
        <h2 id={'depart'}>科室介绍</h2>
        <div className={"picAndWord"}>
          <div className={'pic fl_l'}>
            <img src={require('../asserts/MainImg/dep_1.jpg')} alt={""}/>
          </div>
          <div className={'paragraph fl_r'}>
            <h3>牙体牙髓科</h3>
            <p>科室具有先进的牙体牙髓根尖周疾病的诊疗技术，擅长牙体牙髓根尖周疾病各种常见病，及疑难病例的诊治，聚焦显微根管治疗、根尖手术及牙
              体美学修复，开展多学科联合特色创新技术临床研究，建立牙体牙髓多发病及疑难病显微治疗临床路径，规范牙体牙髓病诊断和治疗流程，显著提高
              根管治疗术的质量和天然牙的保存率，接受全国范围疑难病例转诊，以高超的专业水准和国际化的先进治疗理念得到国内外同行的广泛认可。
              <br/>
              <p>科室拥有一支由35名医师组成的高水平医疗团队，主要毕业于首都医科大学、四川大学华西口腔医学院、北京大学口腔医学院、武汉
              大学口腔医学院、中山大学光华口腔医学院等国内顶级口腔院校，其中博士占比66%，硕士占比28%，高级职称医师占比54%。在全国性根管治疗比
              赛、美学比赛、教学比赛等大赛中多次斩获一、二等奖。
                <Link to={'./depart'}>
                <span className={'toMore'}><RightOutlined />查看更多</span>
                </Link>
              </p>
            </p>
          </div>
        </div>
        <div className={"picAndWord"}>
          <div className={'paragraph fl_l'}>
            <h3>牙周科</h3>
            <p>
              牙周科是集临床、教学和科研于一体的专业科室。
              主要开展急性和慢性牙龈炎、牙龈增生和各种类型的牙周炎的系统治疗。在完善的牙周基础治疗的基础上，开展各种牙周手术，包括牙龈切除术、牙
              周翻瓣术、牙冠延长术以及牙周组织再生术等，帮助患者解决牙周相关问题。
              {/*<br/>*/}
              <p>
              随着基础研究的发展和新技术的应用，牙周科采用了各种新的诊疗技术并开设了特色门诊：采用超声龈下刮治术和牙周“一站式”治疗，减轻牙周基
              础治疗的痛苦并缩短疗程;选择高强度粘接树脂或高弹纤维进行松牙固定术，提高患者的咀嚼功能;为改善患者的美观，开展了义龈的修复以及精细
              的膜龈手术。同时，我们最新引进了激光牙周治疗仪，牙周显微镜等国际先进仪器，为牙周病的治疗开辟新的途径。
              技术力量雄厚的基础教研室为临床服务，可以进行微生物学检测，基因学检测，细胞学、免疫学检查.
              </p>
              <Link to={'./depart'}>
              <span className={'toMore'}><RightOutlined />查看更多</span>
              </Link>
            </p>
          </div>
          <div className={'pic fl_r'}>
            <img src={require('../asserts/MainImg/dep_2.jpg')} alt={""}/>
          </div>
          <div className={"picAndWord"}>
            <div className={'pic fl_l'}>
              <img src={require('../asserts/MainImg/dep_3.jpg')} alt={""}/>
            </div>
            <div className={'paragraph fl_r'}>
              <h3>口腔正畸科</h3>
              <p>
                口腔正畸科是国家重点专科，2014年举行的国家重点临床专科正畸专业评选中获得全国第三名。正畸科拥有先进的技术和设备，目前共有椅位5
                1台,正畸诊室17个,北京卫生重点学科实验室1个,正畸技术室1个,正畸教研室1个，口腔正畸会诊中心一个。
                <p>正畸科拥有丰富经验的临床医师52名,其中主任医师16名、副主任医师17名、主治医师14名、医师5名,其中具有博士学位者46人，硕士学
                位者6人，专业技术队伍年轻、人才梯队合理，每年均有多名医师出国进修和进行学术交流，并且聘请了多名国际知名的正畸专家学者为客座教授。
                正畸科是教育部授权的临床医学博士及硕士学位授予单位，现有博士生导师5名、硕士生导师12名，已经培养超过百名口腔正畸高级专业人才，活
                在临床、教学与科研的第一线。口腔正畸科还是中华医学会口腔正畸专业委员会副主任委员所在单位,拥有雄厚的技术力量和先进的设备使我们
                能够为广大错牙合畸形患者提供优质的服务。</p>
                <Link to={'./depart'}>
                <span className={'toMore'}><RightOutlined />查看更多</span>
                </Link>
              </p>
            </div>
          </div>
          <div className={"picAndWord"}>
            <div className={'paragraph fl_l'}>
              <h3>口腔修复科</h3>
              <p>
                修复科是医院主要临床科室之一，多年来为广大患者提供了优质的医疗服务。科室除拥有43台进口综合治疗台外，还配备有静音无尘研磨刷光机、高压蒸汽清洗机以及器械消毒全套设备。
                修复科在牙体缺损、牙列缺损、牙列缺失以及颌骨缺损的修复方面积累了丰富的临床经验。已有20余年的历史，在多个烤瓷冠和烤瓷长桥的修复方面积累了丰富的经验.
                <p>
                目前，修复科可根据患者的需要及口腔情况制作各类义齿，在可摘义齿方面主要有：胶连义齿、支架义齿(钴铬合金、金合金、钛合金)、覆盖
                义齿等。在固定义齿方面主要有：金属冠桥：可选用镍铬合金、金银钯合金、金合金。烤瓷冠桥：可选用镍铬合金烤瓷冠、金合金烤瓷冠、
                金沉积内冠烤瓷冠以及肩台瓷烤瓷冠、瓷沉积烤瓷冠、全瓷冠、碳纤维桩核等。在全口义齿方面：可选用合资或进口复层树脂牙，选用塑胶、
                钴铬合金基托或金合金、钛合金基托。</p>
                <Link to={'./depart'}>
                <span className={'toMore'}><RightOutlined />查看更多</span>
                </Link>
              </p>
            </div>
            <div className={'pic fl_r'}>
              <img src={require('../asserts/MainImg/dep_4.jpg')} alt={""}/>
            </div>
          </div>
        </div>
      </div>
    )
  }
}
class Doctors extends React.Component{
  render() {
    return(
      <div id={'div1'}>
        <h2 id={'doctors'}>主治医师介绍</h2>
        <Row>
          <Col span={24}>
            <Link to={''}>
              <Card title={'东川里牙科医院院长'} bordered={true} >
                <div id={'div2'}>
                  <img id={'docImgYZ'} src={require('../asserts/MainImg/yuanzhang.png')} alt={""}/>
                  <div id={'docWordDivYZ'} className={'fl_r'}>
                    <p>
                      <span id={'docNameYZ'}>臧滨雨</span>
                      <br/>
                      个人简介
                      主任医师，教授，上海交通大学医学院附属第九人民医院口腔综合科主任，博士学位，博士研究生导师。2005-2006年为美国密歇根大学
                      牙医学院访问学者。曾获“医苑新星”“启明星”人才培养计划。
                      <br/>
                      社会任职
                      中华口腔医学会全科口腔医学专委会副主任委员
                      上海市口腔医学会全科口腔医学专业委员会主任委员
                      <br/>
                      科研成果
                      已发表论文100余篇，其中SCI收录论文17篇。
                      主编和参编《现代根管治疗学》、《老年口腔医学》、《保存牙科学》、《口腔医学（综合）精选模拟习题集》等11部专著。
                      作为主要负责人获国家自然科学基金1项，市局级以上课题8项。在九院口腔综合科工作二十年，具备口腔全科广角与微创诊疗技术，为
                      患者提供个性化最优诊疗方案。
                    </p>
                  </div>
                </div>
              </Card>
            </Link>
          </Col>
        </Row>
        <div style={{marginTop: '15px'}}>
          <Row gutter={8}>
            <Col span={6}>
              <Link to={'/'}>
                <Card title="牙体牙髓科主任" bordered={false}>
                  <img className={'docImg'} src={require('../asserts/MainImg/doc_2.jpg')} alt={""}/>
                  <div className={'fl_r docWordDiv'}>
                    <p>
                      <span className={'docName'}>时献</span>
                      <br/>
                      顶尖医学人才
                      <br/>
                      著名医科大学毕业
                      <br/>
                      专业知识丰富
                    </p>
                  </div>
                </Card>
              </Link>
            </Col>
            <Col span={6}>
              <Link to={'/'}>
                <Card title="牙周科主任" bordered={false}>
                  <img className={'docImg'} src={require('../asserts/MainImg/doc_3.jpg')} alt={""}/>
                  <div className={'fl_r docWordDiv'}>
                    <p>
                      <span className={'docName'}>李钰涵</span>
                      <br/>
                      多年临床，经验丰富
                      <br/>
                      手术技术高超
                      <br/>
                      充分考虑患者状况
                    </p>
                  </div>
                </Card>
              </Link>
            </Col>
            <Col span={6}>
              <Link to={'/'}>
                <Card title="口腔正畸科主任" bordered={false}>
                  <img className={'docImg'} src={require('../asserts/MainImg/doc_4.jpg')} alt={""}/>
                  <div className={'fl_r docWordDiv'}>
                    <p>
                      <span className={'docName'}>宋锦城</span>
                      <br/>
                      正畸领域专家
                      <br/>
                      尤擅长特殊复杂情况
                      <br/>
                      与患者接触较多
                    </p>
                  </div>
                </Card>
              </Link>
            </Col>
            <Col span={6}>
              <Link to={'/'}>
                <Card title="口腔修复科主任" bordered={false}>
                  <img className={'docImg'} src={require('../asserts/MainImg/doc_1.jpg')} alt={""}/>
                  <div className={'fl_r docWordDiv'}>
                    <p>
                      <span className={'docName'}>谷景隆</span>
                      <br/>
                      口腔修复学科代表人
                      <br/>
                      对修复专业见解独到
                      <br/>
                      擅长老人牙齿修复
                    </p>
                  </div>
                </Card>
              </Link>
            </Col>
          </Row>
        </div>
      </div>
    )
  }
}
class Sidebar extends React.Component{
  render() {
    return(
      <div id={'sideBar'}>
        <div className={'piece'}>
          <a href={'#Guide'}>就医指南</a>
        </div>
        <div className={'piece'}>
          <a href={'#Departs'}>科室介绍</a>
        </div>
        <div className={'piece'}>
          <a href={'#div1'}>医生介绍</a>
        </div>
      </div>
    )
  }
}
export default class MainPage extends React.Component {
  render() {
    return (
      <Content style={{padding: '0 50px', marginTop: 64, height: "auto"}}>
        <ShowPic/>
        <Guide/>
        <hr className={'myHr'}/>
        <Depart/>
        <Doctors/>
        <Sidebar/>
      </Content>
    )
  }
}
