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
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
        List<Orders> list = orderRepository.getOrders(doctorId, rsvTime);
        Iterator<Orders> iter = list.iterator();
        if(!iter.hasNext()){
            System.out.println("wrong information about the orders!");
            return null;
        }
        //boolean NumChange = false;
        while(iter.hasNext()) {
            Orders o = iter.next();
            if (o.getDoctorId() == doctorId && Objects.equals(o.getRsvTime(), rsvTime)) {
                //NumChange = true;//确实是要对放号量进行修改
                String sql = "update orders set order_num = ? where ID_d = ? and time_rsv = ?";
                Object[] args = {orderNum, o.getDoctorId(), o.getRsvTime()};
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
        int doctorId = -1;
        doctorId = getDoctorId(doctorName);
        if(doctorId == -1){
            System.out.println("can't find the corresponding doctor!");
            return null;
        }
        return updateOrders(doctorId, orderNum, rsvTime);
    }

    @Override
    public Orders AddNewOrder(String doctorName, int orderNum, String rsvTime)
    {
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
            if(o.getDoctorId() == doctorId && Objects.equals(o.getRsvTime(), rsvTime)){
                System.out.println("the order exists, try to modify it.");
                return updateOrders(doctorId, orderNum, rsvTime);
            }
        }
        Orders order = new Orders();
        order.setDoctorId(doctorId);
        order.setRsvTime(rsvTime);
        order.setOrderNum(orderNum);
        orderRepository.save(order);//若没有相同时间以及医生的对应班次，就先在orders表中添加一条新的纪录
        Arrangement a = new Arrangement();
        int pos = rsvTime.indexOf(',');
        String weekday = rsvTime.substring(0, pos);
        String startTime = rsvTime.substring(pos + 1);
        a.setWeekday(weekday);
        a.setDeptName(dept);
        a.setDoctorId(doctorId);
        a.setStartTime(startTime);
        String time = startTime.substring(2);//获取去除 上午 下午 字样的时间信息
        int pos1 = time.indexOf(':');
        int time1 = Integer.parseInt(time.substring(0, pos1));
        time1 += 2;//获取整数形式的end时间
        String end = Integer.toString(time1);
        String endTime = startTime.substring(0, 2) + end + ":00";
        System.out.println(endTime);//打印出来看看呢
        a.setEndTime(endTime);
        arrangeRepository.save(a);//在orders里面每天加一个新数据，在arrangement里面就要添加一个对应数据
        return order;
    }
}
