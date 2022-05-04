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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
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
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        String time = Time.substring(10);
        if(time.length() == 7){
            time = "0" + time;
        }
        System.out.println(time);
        String date = Time.substring(0, 10);
        System.out.println(date);
        String finalTime = date + " " + time;
        //Registration.lock.lock();
        List<Orders> orders = orderRepository.getOrders(doctorId, finalTime);
        Iterator<Orders> iter = orders.iterator();
        if(!iter.hasNext()){
            System.out.println("Can't find the corresponding order(s)!");
            return null;//没有找到对应的doctor的order
        }
        Orders o = iter.next();
        int MaxNum = o.getOrderNum();
        System.out.println(MaxNum);//打印关键信息
        if(MaxNum <= 0){//没有余下的号
            System.out.println("Don't have left Order Number!");
            return null;
        }
        Registration.lock.lock();
        List<Registration> curOrders = getCurOrders(doctorId, finalTime);
        /*for (Registration reg : curOrders) {
            System.out.println(reg.getRsvTime());
            if (reg.getPatientId() == patientId && Objects.equals(reg.getRsvTime(), finalTime)) {
                System.out.println("can't register for twice at the same time!");
                Registration.lock.unlock();
                return null;//同一个患者不可以在同一个时间段预约两次，避免冲突
            }
        }*/
        Registration reg = new Registration();
        reg.setDoctorId(doctorId);
        reg.setPatientId(patientId);
        reg.setRsvTime(finalTime);
        reg.setState(state);
        reg.setGrabTime("周日9:00");
        regRepository.save(reg);
        String sql = "update orders set order_num = ? where ID_d = ? and time_rsv = ?";
        MaxNum--;
        Object[] args = {MaxNum, doctorId, finalTime};//当前剩余号数量减1
        jdbcTemplate.update(sql, args);
        Registration.lock.unlock();
        return reg;
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
        //List<Registration> ans = new ArrayList<Registration>();
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
        List<Registration> ans = new ArrayList<>();
        for (Registration reg : list) {
            if(reg.getState() == 0 || reg.getState() == 1){
                System.out.println(reg.getDoctorId());
                System.out.println(reg.getRsvTime());
                System.out.println(reg.getPatientId());
                ans.add(reg);//只返回仍在就诊或者还未就诊且未退好的诊号信息
            }
        }
        return ans;
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

    @Override
    public Registration deleteReg(String patientName, String doctorName, String rsvTime)
    {
        String time = rsvTime.substring(10);
        System.out.println(time);
        String date = rsvTime.substring(0, 10);
        System.out.println(date);
        String finalTime = date + " " + time;
        List<Registration> list = getPatientOrders(patientName);
        Iterator<Registration> iter = list.iterator();
        if(!iter.hasNext()){
            System.out.println("Can't find the corresponding registrations!");
            return null;
        }
        int patientId = getPatientIdByName(patientName);
        for(Registration reg : list){
            if(reg.getPatientId() == patientId && Objects.equals(reg.getRsvTime(), finalTime)){
                String sql = "update registration set state = ? where ID_p = ? and time_rsv = ?";
                Object[] args = {2, patientId, finalTime};
                jdbcTemplate.update(sql, args);
                reg.setState(2);
                //regRepository.delete(reg);
                return reg;//找到了目标诊号，直接设置为删除状态(state = 2),这里默认退号发生在出诊之前
            }
        }
        return null;
    }
}

