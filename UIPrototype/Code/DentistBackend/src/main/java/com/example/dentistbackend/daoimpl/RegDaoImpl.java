package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.RegDao;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.entity.Patient;
import com.example.dentistbackend.entity.Registration;
import com.example.dentistbackend.entity.Orders;
import com.example.dentistbackend.repository.DoctorRepository;
import com.example.dentistbackend.repository.OrderRepository;
import com.example.dentistbackend.repository.PatientRepository;
import com.example.dentistbackend.repository.RegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Repository
public class RegDaoImpl implements RegDao{
    @Autowired
    private RegRepository regRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public int getPatientIdByName(String patientName)
    {
        List<Patient> list1 = patientRepository.getPatientByName(patientName);
        Iterator<Patient> iter = list1.iterator();
        int patientId = -1;
        if(iter.hasNext()){
            Patient p = iter.next();
            patientId = p.getPatientId();
        }
        return patientId;
    }

    public int getDoctorIdByName(String doctorName)
    {
        List<Doctor> list1 = doctorRepository.getDoctorByName(doctorName);//根据医生姓名提取id信息
        Iterator<Doctor> iter1 = list1.iterator();
        int doctorId = -1;
        if(iter1.hasNext()){
            Doctor d = iter1.next();
            doctorId = d.getDoctorId();
        }
        return doctorId;
    }

    @Override
    public List<Registration> getCurOrders(int ID_d, String time_rsv)
    {
        return regRepository.getCurOrders(ID_d, time_rsv);
    }

    @Override
    public Registration AddNewReg(int doctorId, int patientId, String Time, int state)
    {
        //List<Registration> list = regRepository.findAll();//获取已经插入的部分
        List<Orders> orders = orderRepository.getOrders(doctorId, Time);
        Iterator<Orders> iter = orders.iterator();
        int MaxNum = 0;
        if(iter.hasNext()){
            Orders o = iter.next();
            MaxNum = o.getOrderNum();//获取doctorId对应的医生班次的最大挂号数量
        }
        System.out.println(MaxNum);//输出关键信息
        Registration.lock.lock();
        List<Registration> curOrders = getCurOrders(doctorId, Time);
        int CurNum = 0;
        for (Registration reg : curOrders) {
            //这里的重复判断在进行postman测试时为了方便注释掉了...
            if (reg.getPatientId() == patientId && Objects.equals(reg.getRsvTime(), Time)) {
                System.out.println("can't register for twice at the same time!");
                Registration.lock.unlock();
                return null;//同一个患者不可以在同一个时间段预约两次，避免冲突
            }
            CurNum++;//获取该医生本班次已经被挂号的数量
        }
        System.out.println(CurNum);//输出关键信息
        if(CurNum < MaxNum){//当前人数小于最大人数，直接添加数据库信息，挂号成功
            //Registration.lock.lock();
            Registration reg = new Registration();
            reg.setDoctorId(doctorId);
            reg.setPatientId(patientId);
            reg.setRsvTime(Time);
            reg.setState(state);
            reg.setGrabTime("周日9:00");
            regRepository.save(reg);
            //regRepository.flush();//立即更新
            System.out.println("successfully saved!");
            Registration.lock.unlock();
            return reg;
        }
        System.out.println("fail to save!");
        Registration.lock.unlock();
        return null;//当前人数大于等于最大人数，则挂号失败(此版本还没有考虑并发情况)
    }

    @Override
    public List<Registration> getPatientOrders(String patientName)//获取某个患者对应的所有挂号信息
    {
        int patientId = getPatientIdByName(patientName);
        if(patientId == -1){
            System.out.println("Wrong Information about the patient!");
            return null;
        }
        List<Registration> list = regRepository.getPatientOrders(patientId);
        for (Registration reg : list) {
            System.out.println(reg.getPatientId());
            System.out.println(reg.getRsvTime());
            System.out.println(reg.getDoctorId());
        }
        return list;
    }

    @Override
    public List<Registration> getDoctorOrders(String doctorName)
    {
        int doctorId = getDoctorIdByName(doctorName);
        if(doctorId == -1){
            System.out.println("Can't find the corresponding doctor!");
            return null;
        }
        List<Registration> list = regRepository.getDoctorOrders(doctorId);
        for (Registration reg : list) {
            System.out.println(reg.getDoctorId());
            System.out.println(reg.getRsvTime());
            System.out.println(reg.getPatientId());
        }
        return list;
    }

    @Override
    public Registration AddNewRegInfo(String doctorName, String patientName, String Time, int state)
    {
        int doctorId = getDoctorIdByName(doctorName);
        if(doctorId == -1){
            System.out.println("Can't find the corresponding doctor!");
            return null;
        }
        int patientId = getPatientIdByName(patientName);
        if(patientId == -1){
            System.out.println("Wrong Information about the patient!");
            return null;
        }
        return AddNewReg(doctorId, patientId, Time, state);
    }
}

