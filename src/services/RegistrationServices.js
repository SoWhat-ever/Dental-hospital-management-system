

let dept = [];
const d = JSON.parse(localStorage.getItem('departments'));
let i;
if (d !== null)
  for (i = 0; i < d.length; i++) {
    dept.push([d[i].depName]);
  }
else dept =
[["口腔正畸科"],
["牙体修复科"],
["牙周科"],
["儿童口腔科"],
["口腔种植科"],
["牙体牙髓科"]];

let doc = [];
const doctor = JSON.parse(localStorage.getItem('doctors'));
for (i = 0; i < doctor.length; i++) {
  doc.push([doctor[i].doctorId, doctor[i].name, doctor[i].image, doctor[i].deptName]);
}


// const doc = [
//   ["1", "段志泽", "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20220128/20220128103746.jpg", "口腔正畸科"],
//   ["2", "武德运", "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20220128/20220128104228.jpg", "牙体修复科"],
//   ["3", "高凯泽", "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20161014/20161014142356.jpg", "牙周科"],
//   ["4", "杜明朗", "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20191102/20191102130757.jpg", "儿童口腔科"],
//   ["5", "潘溥心", "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20161014/20161014135057.jpg", "口腔种植科"],
//   ["6", "何刚毅", "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20160929/20160929095634.jpg", "牙体牙髓科"],
//   ["7", "廖自珍", "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20220128/20220128103746.jpg", "口腔正畸科"],
//   ["8", "乔锐阵", "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20220128/20220128104228.jpg", "牙体修复科"],
//   ["9", "朱正信", "https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20161014/20161014142356.jpg", "牙周科"],
//   ["10", "萧乐山","https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20191102/20191102130757.jpg","儿童口腔科"],
//   ["11", "赵弘懿","https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20161014/20161014135057.jpg","口腔种植科"],
//   ["12", "萧高岑","https://ss.bjmu.edu.cn/Sites/Uploaded/UserUpLoad/20160929/20160929095634.jpg","牙体牙髓科"]
// ]

const orderlist = [
  ["1",30,"2022-05-05 08:30:00"],
  ["1",20,"2022-05-05 14:30:00"],
  ["1",30,"2022-05-07 14:30:00"],
  ["2",20,"2022-05-07 13:30:00"],
  ["3",40,"2022-05-01 14:00:00"],
]
export function getDept() {
  let deptData = [];
  dept.forEach(element => {
      deptData.push(
        {
          name:element[0]
        }
      );
    }
  );
  return deptData;
};

export function getDoctorByDept(deptname){
  let docData=[];
  doc.forEach(element=>{
    if(element[3]===deptname){
      docData.push(
        {
          id:element[0],
          name:element[1],
          img:element[2],
        }
      );
    }
  });
  return docData;
};

export function getDoctor(){
  let docData=[];
  doc.forEach(element=>{

      docData.push(
        {
          id:element[0],
          name:element[1],
          img:element[2],
          dept:element[3]
        }
      );

  });
  return docData;
}

export function getOrderByDoctorAndTime(doctorid){
  let orderData=[];

  orderlist.forEach(element=>{

    if(element[0]===doctorid){
      console.log(doctorid);
      orderData.push(
        {
          remain:element[1],
          date:element[2],
        }
      )
    }
  })
  return orderData;
}
