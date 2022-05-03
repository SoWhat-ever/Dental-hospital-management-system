package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.OrderDao;
import com.example.dentistbackend.entity.Arrangement;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.entity.Orders;
import com.example.dentistbackend.repository.ArrangeRepository;
import com.example.dentistbackend.repository.DoctorRepository;
import com.example.dentistbackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class OrderDaoImpl implements OrderDao{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ArrangeRepository arrangeRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getDoctorId(String doctorName)
    {
        List<Doctor> list = doctorRepository.getDoctorByName(doctorName);
        int doctorId = -1;
        for(Doctor d : list){
            doctorId = d.getDoctorId();
            break;
        }
        return doctorId;
    }

    @Override
    public List<Orders> getOrders(int doctorId, String RsvTime)
    {
        return orderRepository.getOrders(doctorId, RsvTime);
    }

    @Override
    public Orders updateOrders(int doctorId, int orderNum, String rsvTime)
    {
        String date = rsvTime.substring(0, 10);
        String time = rsvTime.substring(10);
        System.out.println(time.length());
        /*if(time.length() == 8){
            time = "0" + time;
            System.out.println(time);
        }*/
        String finalTime = date + time;
        System.out.println(finalTime);
        List<Orders> list = orderRepository.getOrders(doctorId, finalTime);
        Iterator<Orders> iter = list.iterator();
        if(!iter.hasNext()){
            System.out.println("wrong information about the orders!");
            return null;
        }
        //boolean NumChange = false;
        while(iter.hasNext()) {
            Orders o = iter.next();
            System.out.println(o.getRsvTime());
            if (o.getDoctorId() == doctorId && Objects.equals(o.getRsvTime(), finalTime)) {
                //NumChange = true;//确实是要对放号量进行修改
                String sql = "update orders set order_num = ? where ID_d = ? and time_rsv = ?";
                Object[] args = {orderNum, o.getDoctorId(), o.getRsvTime()};
                //System.out.println(finalTime);
                jdbcTemplate.update(sql, args);//此处虽然实现了update但是这种直接用sql的方式并不好，但是暂时没有学会别的方法
                System.out.println("successfully update the order!");
                return o;//此段是update的是最大挂号量
            }
        }
        //此处是检查是否更新了医生某个班次的时间
        /*List<Arrangement> list1 = arrangeRepository.getDoctorArrangement(doctorId);
        for(Arrangement a : list1){
            String startTime = a.getStartTime();
            int pos = startTime.indexOf(',');
            //String weekday = startTime.substring(0, pos);
            String Rsv = startTime.substring(pos + 1);
        }*/
        System.out.println("fail to update!");
        return null;
    }

    @Override
    public Orders updateOrderInfo(String doctorName, int orderNum, String rsvTime)//修改order信息的函数
    {
        String date = rsvTime.substring(0, 10);
        String time = rsvTime.substring(10);
        if(time.length() == 7){
            time = "0" + time;
        }
        String finalTime = date + " " + time;
        int doctorId = -1;
        doctorId = getDoctorId(doctorName);
        if(doctorId == -1){
            System.out.println("can't find the corresponding doctor!");
            return null;
        }
        return updateOrders(doctorId, orderNum, finalTime);
    }

    @Override
    public Orders AddNewOrder(String doctorName, int orderNum, String rsvTime) {
        String date = rsvTime.substring(0, 10);
        String time = rsvTime.substring(10);
        String finalTime = date + " " + time;
        List<Doctor> list1 = doctorRepository.getDoctorByName(doctorName);
        int doctorId = -1;
        String dept = "";
        for(Doctor d : list1){
            doctorId = d.getDoctorId();
            dept = d.getDeptName();
            break;
        }
        if(doctorId == -1){
            System.out.println("can't find the corresponding doctor!");
            return null;
        }
        List<Orders> list = orderRepository.getDoctorOrder(doctorId);
        for(Orders o : list){
            if(o.getDoctorId() == doctorId && Objects.equals(o.getRsvTime(), finalTime)){
                System.out.println("the order exists, try to modify it.");
                return updateOrders(doctorId, orderNum, finalTime);
            }
        }
        Orders order = new Orders();
        order.setDoctorId(doctorId);
        order.setRsvTime(finalTime);
        order.setOrderNum(orderNum);
        orderRepository.save(order);//若没有相同时间以及医生的对应班次，就先在orders表中添加一条新的纪录
        String[] weekDays = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date newDate;
        try
        {
            // 将String类型数据转换成Date类型
            newDate = f.parse(date);
            calendar.setTime(newDate);
        }
        catch
        (ParseException e) {
            e.printStackTrace();
        }
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if(w < 0){
            w = 0;
        }
        String weekday = weekDays[w];
        List<Arrangement> aa = arrangeRepository.getDoctorArrangement(doctorId);
        for(Arrangement aaa : aa){
            if(Objects.equals(aaa.getWeekday(), weekday) && Objects.equals(aaa.getStartTime(), time)){
                System.out.println("The Arrangement already exists!");
                return null;
            }
        }
        Arrangement a = new Arrangement();
        a.setWeekday(weekday);
        a.setStartTime(time);
        a.setDeptName(dept);
        a.setDoctorId(doctorId);
        int len = time.length();
        String endTime = "";
        if(len == 7){
            int start = Integer.parseInt(time.substring(0, 1));
            int end = start + 2;
            String End = Integer.toString(end);
            endTime = End + ":00:00";
        }
        else{
            int start = Integer.parseInt(time.substring(0, 2));
            int end = start + 2;
            String End = Integer.toString(end);
            endTime = End + ":00:00";
        }
        a.setEndTime(endTime);
        arrangeRepository.save(a);
        return order;
    }
}
