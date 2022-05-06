set FOREIGN_KEY_CHECKS=0;
drop table if exists patient;
create table patient
(
    ID_p     int         not null
        primary key,
    name     varchar(20) not null,
    sex      varchar(4)  not null
        check (sex in ('男', '女')),
    age      int         not null
        check (age > 0 and age < 120),
    IDCard   char(18)    not null,
    username varchar(40) not null,
    password varchar(20) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table patient modify ID_p integer auto_increment;

insert patient values (1, "汪鸿哲", "男", "20", "210623200210230002", "patient1", "123456");

insert patient values (2, "汤明俊", "男", "25", "210623200210230001", "patient2", "123456");

insert patient values (3, "卢高畅", "男", "30", "210623200210230006", "patient3", "123456");

insert patient values (4, "史高芬", "男", "35", "210623200210230004", "patient4", "123456");

insert patient values (5, "孔瑞灵", "女", "40", "210623200210230005", "patient5", "123456");

insert patient values (6, "余采春", "女", "35", "210623200210230003", "patient6", "123456");

insert patient values (7, "汤彤云", "女", "30", "210623200210230008", "patient7", "123456");

insert patient values (8, "段芷兰", "女", "20", "210623200210230007", "patient8", "123456");


drop table if exists department;
create table department
(
    dept_name   varchar(50) not null
        primary key,
    position    varchar(100),
    description varchar(2000)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert department values ("牙体牙髓科","住院部1楼101-103",
"牙体牙髓病是指发生在牙齿本身的疾病，以及由此引起的根尖周组织相关疾病。常见的牙体牙髓疾病包括龋病、 非龋性牙体组织缺损（如外伤、楔状缺损、四环素牙、氟牙症等）、牙髓炎和根尖周炎等。本医院的牙体牙髓科是
本院的骨干科室。目前，全科拥有现代化牙科综合诊疗椅38台，能够诊疗各种疑难复杂临床病例。科室内所有医生都
尽全力取服务每一位患者，力求通过精益求精的工作态度以及严谨的工作作风来达到“除人类之病痛，助健康之完美”的崇高目标。");

insert department values ("口腔正畸科","住院部1楼105-107",
"本院正畸科专注于口腔正畸临床治疗和教学科研工作，是我国成立最早、综合实力最强、接诊量最大的专业化口腔正畸科室之一。正畸科自1949年由我国正畸学奠基人毛燮均教授创建以来，在黄金芳、傅民魁、林久祥等一代又一代北医正畸人的带领下，守正创新、团结进取，在临床、教学、科研等领域始终走在国内正畸界前列，获得国家级、教育部、卫生部、上海市、中华医学奖等奖励，入选2016—2018年度国家临床重点专科建设项目。

　　正畸科是国内领先的正畸诊疗中心，现有正畸医师中92%拥有博士学位，大部分有一年及以上海外留学经历，在国内率先开展正畸正颌联合治疗、唇腭裂患者正畸治疗、呼吸睡眠暂停正畸治疗等领域临床治疗，率先应用种植体支抗、传动矫治技术，PASS矫治技术、舌侧矫治技术、无托槽隐形矫治技术等先进临床治疗技术。

　　正畸科是教书育人的规范化专科医师培训基地，现有博士生导师9名，硕士生导师8名，承担本科生、研究生、以及规培医生正畸相关领域课程教学，同时开展对口援建和进修医师培养工作，主持编写第一至五版全国统编口腔正畸学，第一、二版口腔正畸学研究生教材，教育部十一五规划口腔正畸学长学制教材第一、二版。");

insert department values ("牙体修复科","住院部2楼201-203",
"口腔修复科历史悠久，这里先后诞生了毛燮均、钟之琦、朱希涛、王洁泉、王毓英等中国口腔医学界泰斗。该学科是国务院首批博士、硕士学位授予学科之一。

　　2011年口腔修复科以优异的成绩获批国家临床重点专科建设项目，其医疗、教学、科研水平在全国处于领先地位，在我国口腔修复领域发挥了重要的引领作用。近年来，先后获得上海市科学技术奖、华夏医学科技奖、中华口腔医学科技奖、上海市教育教学成果奖、中国学位与研究生教育学会医药学研究生教育成果奖、精品课程等多项成果。在医师中，超过80%具有博士学位，一半以上曾赴欧、美、日留学进修一年以上，拥有长江学者、国家百千万人才(国家有突出贡献中青年专家)、国务院政府特殊津贴获得者、教育部新世纪优秀人才、首都科技领军人才、上海市科技新星等各级人才10余名;拥有十余名在职博士生导师。口腔修复学教研室有多名教授就任中华口腔医学会口腔修复专业委员会、口腔颌面修复学专委会、口腔美学专委会、口腔医学计算机专委会、口腔修复工艺学专业委员会主任委员、副主任委员等职务，另有多名医师在国际、亚洲、全国性和上海市学术组织中承担委员及以上职务。有多名医师担任国际、国内学术杂志编委，有多名医师担任国家级规划教材和上海市精品教材主编或副主编，有多名医师担任上海市及以上医学会医疗事故鉴定专家。");

insert department values ("牙周科","门诊部3楼305-307",
"我院院牙周科始建于1953年，1980年代初全面引进国际先进理念，建成集医疗、教学、科研三个职能为一体的专业科室。2010年在首次国家临床重点专科建设项目评比中，位列全国牙周病学专业的第一名。

　　我院院牙周科长期坚持牙周疾病的规范化系统治疗，对重度和复杂的牙周炎患者进行以牙周专业为主导的多学科治疗，获得了良好的效果，保留了数万计患者的天然牙，大大提高了患者的生活质量，治疗技术达国际水平。牙周科率先或较早地在国内开展了牙周组织再生治疗、美学区及功能区牙周成形与重建手术、牙周病患者的种植治疗、种植体周围病治疗。掌跖角化-牙周破坏综合征、急性白血病、恶性淋巴瘤、郎罕氏细胞组织细胞增多症、低磷酸酯酶症、Laband综合征等疑难病在我科得到确诊和针对性牙周治疗。

　　目前总院共有38名医师，其中6名教授(均为博士生导师)，6名主任医师，3名副教授，7名副主任医师，91%的医师具有博士学位，5位具有硕士生导师资格。牙周科有主任技师1名，洁治员11名，其中10名具有医师资格。35名护士，副主任护师1名，主管护师19名，护师14名。聘有外籍客座教授2人，与国际、国内知名牙周病学专家、学科保持密切联系和经常性学术交流。牙周科共有58台综合治疗椅, 每天接诊来自全国各地及海内外患者四百余人。同时承担中央首长的牙周保健工作。每年培训来自全国各口腔医学院校进修医师十余人，护士十余人，举办10期以上国家级牙周临床专项技术培训项目。30年来，我院牙周病学专业口腔医学本科教育形成了以临床培养为中心的教学体系，成为我国口腔医学中牙周病学教学示范单位;牙周科是牙周病学专业全国最早的博士点单位，也是牙周病学博士后流动站，每年培养研究生十余名，是全国高等学校教材《牙周病学》、普通高等教育“十一五”国家级规划教材《临床口腔医学》主编单位。受卫生部委托主持撰写了我国第一部《中国牙周病防治指南》。是国家级牙周继续教育培训基地，国家药监局药物临床研究基地。近15年获得国家自然科学基金28项，省部级科研基金26项，发表SCI收录论文100余篇，荣获多项省部级奖项。");

insert department values ("儿童口腔科","门诊部2楼201-203",
                          "本院口腔科是国家临床重点专科，始建于1951年，历史悠久。目前拥有两大诊区，分别位于总院五层(魏公村)和第一门诊部C楼二层(西四)，共有18间诊室，39台综合治疗台，两间儿童口腔科全身麻醉下治疗诊室和复苏室，独立的儿童口腔科技工室，是我国配置最完善，规模最大的儿童口腔医学专业科室。我科技术力量雄厚，拥有一大批高水平临床和研究专业人才，医护技共77人，高级技术职称16人，博士生导师4人。36名医师中32人具有博士学位，有一年以上国外学习经历者16人。

　　从2018年起年诊疗患者超过10万人次。诊疗内容主要有：1)儿童龋病;2)儿童牙髓病与牙髓组织再生;3)儿童牙外伤; 4)儿童牙颌发育异常;5)口腔出现表征的遗传性疾病及相关综合征; 6)儿童牙周粘膜组织疾患等。诊疗标准和技术手段与国际先进水平同步。我科拥有一批特色技术，如：年轻恒牙活髓保存与牙髓再生技术、低龄儿童重度龋标准化诊疗及评估系统、儿童髁突骨折的保守治疗、微创技术体系、特殊儿童的牙科治疗(残障、先天无牙牙合、严重全身系统病儿童等)、咬合诱导(包括错牙合畸形的早期矫治等)等。我科于1999年实施了我国首例全身麻醉下儿童牙病治疗，迄今已20余年，累计完成9000余例。我科的发展目标是建设集高层次人才培养、先进医疗服务、高水平科研与转化为一体，能承担重要社会责任并体现社会公益性的国内领先、在世界上具有较强竞争力的儿童口腔医学专科。");


insert department values ("口腔种植科", "门诊楼7层",
                          "本院种植科成立于1997年，是国内最早成立的种植专业科室之一，是一个专门从事口腔种植临床工作的专业化科室，在国内外口腔种植学界享有较高知名度和影响力。自1998年来，在国内最早开展并报道了多种骨增量技术，如GBR技术、上颌窦底提升植骨技术、外置法植骨技术等，均已成为本科室开展的常规外科技术。自2008年来，在国内最早开展无牙颌患者的All-on-4技术。患者当天拔除口内余留患牙，即刻植入种植体，当天完成即刻固定修复并行使咀嚼功能。 自2009年来，在国内率先开展前牙即刻种植即刻美学修复技术，实现前牙当天拔除、种植、当天即刻固定修复，满足了患者对美观的要求。科室十多年来已完成3万余例各种条件下的牙种植修复,种植体十年存留率达96.7%，达到国际口腔种植存留率标准。科室装备有六套国际著名种植系统及全套种植设备，国际一流的专用手术设备，专用消毒设备和国际一流水准的专业修复技工室，包括德国Kavo everest CAD/CAM加工系统，Nobelbiocare Procera系统，Sirona CAD/CAM系统， 瑞士Ivoclar烤瓷及铸瓷设备，德国AEC CAD/CAM 系统及全自动激光铸造机等国际先进加工设备。科室由受过专门系统培训的种植外科医师(教授1人，副教授3人)、种植修复医师(主任医师2人，主治医师4人)、修复工艺技师(主管技师2人，技师9人)及护理人员(主管护师2人，护师7人)组成专业种植团队。所有的医师、技师均在德国、瑞士、美国等接收过多次专业培训与学习。规范化于专业化是科室的宗旨与特色。

　　科室装备有3D锥形束CT-曲断一体机1台，牙科综合治疗台7个，专用手术间3个，内窥镜2台，麻醉机1台，超声骨刀4台。另有隶属本科室种植专用技工室1个，拥有CAD/CAM三套，电火花加工中心1台，激光焊接机1台，全自动铸造机2台等。");


drop table if exists doctor;
create table doctor
(
    ID_d        int         not null
        primary key,
    name        varchar(20) not null,
    password    varchar(20) not null,
    image       varchar(255),
    dept_name   varchar(50),
    title       varchar(500),
    description varchar(2000),
    foreign key (dept_name) references department (dept_name)
        on delete set null,
    username varchar(20) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

delimiter $$
drop procedure if exists insert_doctor;
create procedure insert_doctor()
begin
    declare i int;
    declare n varchar(20);
    declare img varchar(255);
    declare dept varchar(20);
    declare tle varchar(500);
    set i = 1;
    while (i <37)
    do
        set n = elt(i%20+1,"尹元正","段志泽","武德运","高凯泽","杜明朗","潘溥心","何刚毅","廖自珍","乔锐阵","朱正信","萧乐山","赵弘懿","萧高岑","黎自明","陈元龙","康烨伟","赵德曜","江开霁","魏刚洁","许昊穹","马茂勋","范力强","田宇寰","金开霁","毛承望","姜俊杰","董和豫","丁正青","马博达","金智渊","阎心水","乔鸿宝","常明喆","姜文曜","马浩荡","钱嘉致");
        set img = elt(i%6+1, "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20160929/20160929095634.jpg",
            "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20220128/20220128103746.jpg",
            "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20220128/20220128104228.jpg",
            "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20161014/20161014142356.jpg",
            "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20191102/20191102130757.jpg",
            "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20161014/20161014135057.jpg");
        set dept = elt(i%6+1, "牙体牙髓科", "口腔正畸科", "牙体修复科", "牙周科","儿童口腔科","口腔种植科");
        set tle = elt(i%6+1,
            "职称：主任医师
专长：牙体牙髓常见病疑难病诊断治疗，显微根管治疗，牙齿美白美容修复。",
            "职称：副主任医师
专长：牙体牙髓常见病疑难病诊断治疗，显微根管治疗，牙齿美白美容修复。",
            "职称：主任医师
专长：牙体牙髓常见病疑难病诊断治疗，显微根管治疗，牙齿美白美容修复。",
            "职称：副主任医师
专长：牙体牙髓常见病疑难病诊断治疗，显微根管治疗，牙齿美白美容修复。",
            "职称：副主任医师
专长：牙体牙髓常见病疑难病诊断治疗，显微根管治疗，牙齿美白美容修复。",
            "职称：主治医师
专长：牙体牙髓常见病疑难病诊断治疗，显微根管治疗，牙齿美白美容修复。");
        insert doctor values (i,n, "123456", img, dept, tle, "副教授 研究生导师，1991年毕业留校，1995年开始从事种植专业工作，2002年赴德国Filderstadt种植医院接受系统规范的种植专业训练;2007年前往欧美深入探寻无牙颌种植固定修复先进技术和修复理念，并成功用于我国无牙颌患者;2009年—2010年间在德国图宾根大学师从著名的Weber教授深化种植修复相关理论，多次赴欧洲、美国、和亚太地区学术交流。在多年临床实践基础上，将现代种植学理论，自然协调的美学修复观念以及规范的专业技术用于临床工作。获中华口腔医学科技一等奖(2014年)，中华医学科技奖二等奖(2010年)，多次获得口腔医学院优秀医疗工作奖。",
                              concat("doc", i));
        set i = i+1;
    end while;

end $$
delimiter ;

call insert_doctor();

alter table doctor modify ID_d integer auto_increment;

drop table if exists admin;
create table admin
(
    ID_a     int not null
        primary key,
    username varchar(20) not null ,
    password varchar(20) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert admin values (1, "admin1", "123456");

insert admin values (2, "admin2", "123456");

insert admin values (3, "admin3", "123456");


drop table if exists registration;
create table registration
(
    ID_r      int not null
        primary key,
    ID_p      int,
    ID_d      int,
    time_rsv  DateTime,
    time_grab char(14),
    state     int not null
        check (state in (0, 1, 2, 3, 4)),
    foreign key (ID_p) references patient (ID_p)
        on delete cascade,
    foreign key (ID_d) references doctor (ID_d)
        on delete set null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table registration modify ID_r integer auto_increment;

/*insert registration values (1, 1, 1, "2022-5-2 15:00:00", "周日9:00", 0);

insert registration values (2, 2, 1, "2022-5-2 15:00:00", "周日9:00", 0);*/

/*insert registration values (1, 1, 1, "周一9:00","周日9:00", 0);

insert registration values (2, 2, 1, "周二9:00","周日9:00", 1);

insert registration values (3, 3, 2, "周一15:00","周日9:00", 2);

insert registration values (4, 4, 2, "周二15:00","周日9:00", 3);

insert registration values (5, 5, 2, "周三15:00","周日9:00", 4);

insert registration values (6, 6, 3, "周四9:00","周日9:00", 4);

insert registration values (7, 7, 4, "周日9:00","周日9:00", 3);

insert registration values (8, 8, 5, "周四15:00","周日9:00", 2);*/



drop table if exists arrangement;
create table arrangement
(
    number     int         not null
        primary key,
    weekday    varchar(12) not null
        check (weekday in ('星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期日')),
    time_start varchar(10)  not null,
    time_end   varchar(10)  not null,
    dept_name  varchar(50) not null,
    ID_d       int         not null,
    foreign key (dept_name) references department (dept_name)
        on delete cascade,
    foreign key (ID_d) references doctor (ID_d)
        on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table arrangement modify number integer auto_increment;

insert arrangement values (1, "星期一", "9:00:00", "11:00:00", "牙体牙髓科", 3);

insert arrangement values (2, "星期一", "15:00:00", "17:00:00", "口腔正畸科", 1);

insert arrangement values (3, "星期二", "9:00:00", "11:00:00", "牙周科", 5);

insert arrangement values (4, "星期二", "15:00:00", "17:00:00", "牙体修复科", 6);

insert arrangement values (5, "星期三", "9:00:00", "11:00:00", "牙体牙髓科", 4);

insert arrangement values (6, "星期三", "15:00:00", "17:00:00", "牙周科", 5);

insert arrangement values (7, "星期四", "9:00:00", "11:00:00", "牙体修复科", 6);

insert arrangement values (8, "星期四", "15:00:00", "17:00:00", "口腔正畸科", 2);

insert arrangement values (9, "星期五", "9:00:00", "11:00:00", "牙体牙髓科", 4);

insert arrangement values (10, "星期五", "15:00:00", "17:00:00", "口腔正畸科", 1);

insert arrangement values (11, "星期六", "9:00:00", "11:00:00", "牙体修复科", 6);

insert arrangement values (12, "星期日", "9:00:00", "11:00:00", "牙周科", 5);





drop table if exists process_d;
create table process_d
(
    dept_name    varchar(50)   not null,


    disease_name varchar(50)   not null,
    step_d       int           not null
        check (step_d > 0),
    content      varchar(2000) not null,
    primary key (dept_name, disease_name, step_d),
    foreign key (dept_name) references department (dept_name)
        on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# insert process_d values ("牙体牙髓科", "牙髓疾病", 1, "初次诊疗,决定进行牙体牙髓手术");
#
# insert process_d values ("牙体牙髓科", "牙髓疾病", 2, "复诊1,术后恢复良好,开具药方1");
#
# insert process_d values ("牙体牙髓科", "牙髓疾病", 3, "复诊2,复诊1的药效良好,继续服用一周");
#
# insert process_d values ("牙体牙髓科", "牙髓疾病", 4, "复诊3,患者痊愈,继续服药三天后停止服用,完成疗程");

delimiter $$
drop procedure if exists insert_pro_d;
create procedure insert_pro_d(IN name_dept varchar(50), IN name_dis varchar(50))
begin
    insert process_d values (name_dept, name_dis, 1, "初次诊");
    insert process_d values (name_dept, name_dis, 2, "复诊1");
    insert process_d values (name_dept, name_dis, 3, "复诊2");
    insert process_d values (name_dept, name_dis, 4, "复诊3");
end $$
delimiter ;

call insert_pro_d("牙体牙髓科", "牙髓病");

call insert_pro_d("牙体牙髓科", "牙齿硬组织缺陷");

call insert_pro_d("口腔正畸科", "颞下颌关节紊乱病");

call insert_pro_d("牙体修复科", "牙缺失");
call insert_pro_d("牙周科", "牙周炎");

call insert_pro_d("牙周科", "牙龈增生");

call insert_pro_d("儿童口腔科", "咬合诱导");

call insert_pro_d("儿童口腔科", "儿童髁突骨折");

call insert_pro_d("口腔种植科", "牙体种植");


drop table if exists process_p;
create table process_p
(
    ID_r         int           not null,
    ID_d         int,
    step         int           not null
        check (step > 0),
    disease_name varchar(50)   not null,
    content      varchar(2000) not null,
    comment      varchar(2000),
    /*primary key (ID_r, step, disease_name),*/
		/*此处不在将diseasename作为一个主键*/
		primary key (ID_r, step),
    foreign key (ID_r) references registration (ID_r)
        on delete cascade,
    foreign key (ID_d) references doctor (ID_d)
        on delete set null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert process_p values (1, 1, 1, "牙髓疾病", "初次诊疗,决定进行牙体牙髓手术", "这个医生很好");

insert process_p values (1, 1, 2, "牙髓疾病", "复诊1,术后恢复良好,开具药方1", "这个医生很好");

insert process_p values (1, 1, 3, "牙髓疾病", "复诊2,复诊1的药效良好,继续服用一周", "这个医生很好");

insert process_p values (1, 1, 4, "牙髓疾病", "复诊3,患者痊愈,继续服药三天后停止服用,完成疗程", "这个医生很好");

insert process_p values (2, 1, 3, "口腔疾病", "初次诊疗,开具药方2", "这个医生很不错");

drop table if exists orders;
create table orders
(
    ID_d      int      not null,
    order_num int      not null,
    time_rsv  DateTime not null,
    primary key (ID_d, time_rsv),
    foreign key (ID_d) references doctor (ID_d)
        on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*delimiter $$
drop procedure if exists insert_order;
create procedure insert_order()
begin
    declare i int;
    declare val varchar(20);
    set i = 1;
    while (i <36)
    do
        set val = elt(i%7+1, '上午9：00', '上午10：00', '下午13：00', '下午14：00', '下午15：00', '下午16：00', '下午17：00');
        insert orders values (i, i, val);
        set i = i+1;
    end while;

end $$
delimiter ;

call insert_order();*/

insert orders value (1, 10, "2022-5-2 15:00:00");

insert orders value (1, 30, "2022-5-6 15:00:00");

insert orders value (2, 30, "2022-5-5 15:00:00");

insert orders value (3, 30, "2022-5-2 9:00:00");

insert orders value (4, 30, "2022-5-4 9:00:00");

insert orders value (4, 30, "2022-5-6 9:00:00");

insert orders value (5, 30, "2022-5-3 9:00:00");

insert orders value (5, 30, "2022-5-4 15:00:00");

insert orders value (5, 30, "2022-5-8 9:00:00");

insert orders value (6, 30, "2022-5-3 15:00:00");

insert orders value (6, 30, "2022-5-5 9:00:00");

insert orders value (6, 30, "2022-5-7 9:00:00");

set FOREIGN_KEY_CHECKS=1;