import React from "react";
import MyHeader from '../../components/MyHeader';
import MyFooter from '../../components/MyFooter';
import {Layout} from "antd";
import {Tabs} from 'antd';
import {SolutionOutlined, FileMarkdownOutlined, FieldTimeOutlined} from '@ant-design/icons';
import './doctor.css';

const {Content} = Layout;
const {TabPane} = Tabs;

export default class Index extends React.Component {
  render() {
    return (
      <Layout>
        <MyHeader/>
        <Content style={{padding: '0 50px', marginTop: 64, height: "auto"}}>
          <div style={{marginTop: '30px', paddingLeft: '30px',}}>
            <div style={{float: "left", width: '25%', height: '400px',}}>
              <img src={require('../../asserts/MainImg/yuanzhang.png')}/>
            </div>
            <div style={{float: "right", width: '75%', height: '400px', paddingTop: '50px'}}>
              <span style={{fontSize: '25px'}}>毕增祺</span>
              <div style={{marginTop: '30px', fontSize: '16px'}}>
                <p>
                  主任医师 教授 博士研究生导师 Professor
                </p>
                <p>
                  擅长 : 对各种肾脏病的诊治有扎实的理论基础和丰富的临床经验。运动神经元病、周围神经病、肌肉病等神经系统的各种疑难杂症
                </p>
                <p>
                  Diagnosis and treatment of various kidney diseases.Complex and rare neurological disorders such as
                  motor neuron disease, peripheral neuropathy, and myopathy, etc.
                </p>
              </div>
              <div>
                <a id={'findInfo'}>
                  <FieldTimeOutlined style={{fontSize: '40px',color: '#40a9ff'}}/>
                  <span style={{fontSize: '20px'}}>
                    点击查看出诊信息
                  </span>
                </a>
              </div>
            </div>
          </div>
          <div style={{marginTop: '30px', paddingLeft: '30px',}}>
            <span style={{fontSize: '20px', fontWeight: "bold"}}>详细介绍</span>
            <div style={{marginTop: '30px', textIndent: '2em', color: 'dimgray'}}>
              <p>
                毕增祺，男，1925年生，安徽歙县人。主任医师、教授，博士生导师。
              </p>
              <p>
                1952年毕业于上海同济大学医学院。1955-1959年在前苏联列宁格勒医学院学习，获副博士学位。1959年回国，开始在北京协和医院内科工作。196
                2年学习中医两年，在湖北中医医学院师从名老中医张梦龙等。以后，在北京协和医院心、肾科工作，长期将中西医的理论和思想方法应用于临床。
                1972年，在中美未建交前，受国务院指派，任首届我国常驻联合国代表之一，担任代表团医疗等工作。1976年回国，1980年在北京协和医院创建肾脏病科。
              </p>
              <p>
                1984年，在我国最早报告IgA肾病。最早倡导对慢性肾衰竭进行早期防治，提出非透析的综合治疗。对防止慢性肾功能进行性恶化，在早、中期防治做了系列性研究，其中对中药大黄等治疗作用，作了临床严谨观察和效果的肯定，并证明中西医结合治疗有延缓慢性肾功能衰竭恶化作用。曾用中、外文发表论著多篇，有较大影响。对慢性肾衰竭患者营养问题，首先研究和应用我国自制的多种必需氨基酸治疗肾功能衰竭，配合低蛋白饮食为该病营养治疗奠定了基础。科研成果在二十世纪80年代获中国医学科学院科研成果奖。还研究证明了中西医结合治疗老年慢性肾功能衰竭，对部分老年病人能延缓恶化甚至部分病人可以好转（中华老年杂医学杂志，1995，21：89）。此外，对各种继发性肾病包括狼疮性肾炎、干躁综合症肾炎、糖尿病肾病，老年肾脏病的诊治等均进行了不少临床和研究工作。曾先后三次受国家政府派遣，带领中西医治疗小组为国外政要人士治病。
              </p>
              <p>
                曾发表论文、著作百余篇。曾参加编写中国大百科全书医学部分等。1994年参加方圻教授主编的现代内科学编写，任编委，该书已获国家级二等奖。2003年主编“慢性肾功能衰竭—临床防治和理论基础”一书，由中国协和医科大学出版社出版。1952年在上海立二等功、1991年获国务院政府特殊津贴。1999年中央保健委员会授予荣誉证书。1996年，被中国科协评为为“中国科学技术协会先进工作者”。曾任中华医学会理事、名誉理事。是中华医学会肾脏病学会创始人之一，任第1届常委和2-4届副主任委员、曾任中华内科、中华老年杂志编委。现任国外医学泌尿系分册副主编，临床肾脏病杂志名誉主编，中华实用内科等杂志编委、美国Geriatric
                Nephrology and Urology（国际老年肾脏病杂志）编委。为北京老年医药卫生工作者协会知名专家委员会委员。2007年，中华肾脏病学会授予卓越贡献奖，2009年北京协和医院杰出贡献奖。
              </p>
            </div>
          </div>
          <hr id={'myHr'}/>
          <div style={{width: '60%', marginLeft: '20%', marginTop: '30px'}}>
            <Tabs defaultActiveKey="1" centered size={'small'}>
              <TabPane
                tab={
                  <span>
                  <SolutionOutlined/>
                  相关资讯
                </span>
                }
                key="1"
              >
                <div className={'reports'}>
                  <a>
                    <span className={'report'}>光明日报 ｜ 百年医脉 历久弥坚 </span>
                    <span>发表日期：2022.1.29 </span>
                  </a>
                </div>
                <div className={'reports'}>
                  <a>
                    <span>"永远做人民需要的医生"</span>
                    <span className={'time'}>发表日期：2022.2.19 </span>
                  </a>
                </div>
                <div className={'reports'}>
                  <a>
                    <span>光明日报 ｜ 医者仁心铸就的传奇</span>
                    <span className={'time'}>发表日期：2022.3.20 </span>
                  </a>
                </div>
                <div className={'reports'}>
                  <a>
                    <span>光明日报 ｜ 医者仁心铸就的传奇</span>
                    <span className={'time'}>发表日期：2022.4.15 </span>
                  </a>
                </div>
              </TabPane>
              <TabPane
                tab={
                  <span>
                 <FileMarkdownOutlined/>
                  相关文章
                </span>
                }
                key="2"
              >
                暂无数据
              </TabPane>
            </Tabs>
          </div>
        </Content>
        <MyFooter/>
      </Layout>
    )
  }
}
