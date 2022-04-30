package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.RegDao;
import com.example.dentistbackend.entity.Registration;
import com.example.dentistbackend.entity.Orders;
import com.example.dentistbackend.repository.OrderRepository;
import com.example.dentistbackend.repository.RegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.KeyHolder;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static org.springframework.jdbc.support.KeyHolder.*;

@Repository
public class RegDaoImpl implements RegDao{
    @Autowired
    private RegRepository regRepository;
    @Autowired
    private OrderRepository orderRepository;

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
        while(iter.hasNext()){
            Orders o = iter.next();
            MaxNum = o.getOrderNum();//获取doctorId对应的医生班次的最大挂号数量
            break;
        }
        System.out.println(MaxNum);//输出关键信息
        List<Registration> curOrders = getCurOrders(doctorId, Time);
        int CurNum = 0;
        Iterator<Registration> iter1 = curOrders.iterator();
        while(iter1.hasNext()){
            Registration reg = iter1.next();
            if(reg.getPatientId() == patientId && Objects.equals(reg.getRsvTime(), Time)){
                System.out.println("can't register for twice at the same time!");
                return null;//同一个患者不可以在同一个时间段预约两次
            }
            CurNum++;//获取该医生本班次已经被挂号的数量
        }
        System.out.println(CurNum);//输出关键信息
        if(CurNum < MaxNum){//当前人数小于最大人数，直接添加数据库信息，挂号成功
            Registration reg = new Registration();
            reg.setDoctorId(doctorId);
            reg.setPatientId(patientId);
            reg.setRsvTime(Time);
            reg.setState(state);
            reg.setGrabTime("周日9:00");
            regRepository.save(reg);
            //regRepository.flush();//立即更新
            System.out.println("successfully saved!");
            return reg;
        }
        System.out.println("fail to save!");
        return null;//当前人数大于等于最大人数，则挂号失败(此版本还没有考虑并发情况)
    }
}

