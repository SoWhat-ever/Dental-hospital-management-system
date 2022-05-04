import axios from "axios";
import {history} from "../.umi/core/history";

export const login = (values) => {
  let request;
  let userType;
  if (values.identity === '患者') {request = 'checkPatient'; userType = 1;}
  else if (values.identity === '医生') {request = 'checkDoctor'; userType = 2;}
  else {request = 'checkAdmin';userType = 3;}

  axios({
    method: 'GET',
    url: 'http://localhost:8080/'+request,
    params: {
      username: values.username,
      password: values.password
    }
  }).then(response => {
    console.log(response)
    if (response.status === 200) {
        localStorage.setItem('userType', userType);
        localStorage.setItem('user', JSON.stringify(response.data));
    }
  }).catch(error => {
    console.log(error)
    console.log("登陆失败！")
    alert("账号或密码错误");
  })
}

// export const order = (values) => {
//   let request;
//   let userType;
//   if (values.identity === '患者') {request = 'checkPatient'; userType = 1;}
//   else if (values.identity === '医生') {request = 'checkDoctor'; userType = 2;}
//   else {request = 'checkAdmin';userType = 3;}
//
//   axios({
//     method: 'POST',
//     url: 'http://localhost:8080/'+request,
//     params: {
//       username: values.username,
//       password: values.password
//     }
//   }).then(response => {
//     console.log(response)
//     if (response.status === 200) {
//       localStorage.setItem('userType', userType);
//       localStorage.setItem('user', JSON.stringify(response.data));
//     }
//   }).catch(error => {
//     console.log(error)
//     console.log("登陆失败！")
//     alert("账号或密码错误");
//   })
// }
