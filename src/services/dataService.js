import axios from "axios";

// 用来获取医生和科室信息
export const getDoctorAndDept = () => {

  axios({
    method: 'GET',
    url: 'http://localhost:8080/getDoctors',
    params: {

    }
  }).then(response => {
    console.log(response)
    if (response.status === 200) {
      localStorage.setItem('doctors', JSON.stringify(response.data));
    }
  }).catch(error => {
    console.log(error)
    console.log("获取失败！")
  })

  axios({
    method: 'GET',
    url: 'http://localhost:8080/getDepartments',
    params: {

    }
  }).then(response => {
    console.log(response)
    if (response.status === 200) {
      localStorage.setItem('departments', JSON.stringify(response.data));
    }
  }).catch(error => {
    console.log(error)
    console.log("获取失败！")
  })
}

export const addOrder=(values)=>{
  axios({
    method: 'POST',
    url: 'http://localhost:8080/addOrder',
    params: {
      doctorName:values.name,
      ordernum:values.num,
      rsvTime:values.date
    }
  }).then(response => {
    console.log(response)

  }).catch(error => {
    console.log(error)
    console.log("获取失败！")
  })

}

