package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.ArrangeDao;
import com.example.dentistbackend.entity.Arrangement;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.entity.Orders;
import com.example.dentistbackend.repository.ArrangeRepository;
import com.example.dentistbackend.repository.DoctorRepository;
import com.example.dentistbackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Repository
public class ArrangeDaoImpl implements ArrangeDao {
    @Autowired
    private ArrangeRepository ArrangeRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Arrangement findOne(Integer id)
    {
        return ArrangeRepository.getOne(id);
    }

    @Override
    public List<Arrangement> getArrangements()
    {
        return ArrangeRepository.getArrangements();
    }

    @Override
    public List<Arrangement> getDoctorArrangement(String doctorName)
    {
        List<Doctor> list1 = doctorRepository.getDoctorByName(doctorName);
        int doctorId = -1;
        for(Doctor d : list1){
            doctorId = d.getDoctorId();
            break;
        }
        if(doctorId == -1){
            System.out.println("Can't find the corresponding doctor!");
            return null;
        }
        return ArrangeRepository.getDoctorArrangement(doctorId);
    }

    @Override
    public List<Arrangement> getWeekdayArrangement(String weekday)
    {
        return ArrangeRepository.getWeekdayArrangement(weekday);
    }

    @Override
    public Arrangement AddNewArrangement(String weekday, String startTime, String doctorName,
                                         int orderNum)
    {
        List<Doctor> list1 = doctorRepository.getDoctorByName(doctorName);
        Iterator<Doctor> iter = list1.iterator();
        if(!iter.hasNext()){
            System.out.println("Can't find the corresponding doctor!");
            return null;
        }
        int doctorId = -1;
        String dept = "";
        Doctor doctor = iter.next();
        doctorId = doctor.getDoctorId();
        dept = doctor.getDeptName();
        List<Arrangement> arrangelist = ArrangeRepository.getDoctorArrangement(doctorId);
        for(Arrangement a : arrangelist){
            if(Objects.equals(a.getWeekday(), weekday)
                    && Objects.equals(a.getStartTime(), startTime)){
                System.out.println("The arrangement already exists!");
                return null;
            }
        }
        //在arrangement表中进行插入
        Arrangement a = new Arrangement();
        a.setDoctorId(doctorId);
        a.setWeekday(weekday);
        a.setStartTime(startTime);
        a.setDeptName(dept);
        String time1 = startTime.substring(0, 2);//获取 上午 或者 下午
        String time2 = startTime.substring(2);//获取？:00
        int pos = time2.indexOf(':');
        int end = Integer.parseInt(time2.substring(0, pos));
        end += 2;
        String endTime = Integer.toString(end);
        String finalEnd = time1 + endTime + ":00";
        System.out.println(finalEnd);
        a.setEndTime(finalEnd);
        ArrangeRepository.save(a);//记得保存
        //在orders中进行插入
        Orders order = new Orders();
        order.setDoctorId(doctorId);
        order.setOrderNum(orderNum);//这里一般默认30(随便编的。。。)
        String Rsv = weekday + "," + startTime;
        order.setRsvTime(Rsv);
        orderRepository.save(order);//记得保存
        return a;
    }
}
