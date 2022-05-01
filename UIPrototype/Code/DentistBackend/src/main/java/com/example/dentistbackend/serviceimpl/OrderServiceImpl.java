package com.example.dentistbackend.serviceimpl;
import com.example.dentistbackend.dao.OrderDao;
import com.example.dentistbackend.entity.Orders;
import com.example.dentistbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;

    @Override
    public Orders updateOrderInfo(String doctorName, int orderNum, String rsvTime)
    {
        return orderDao.updateOrderInfo(doctorName, orderNum, rsvTime);
    }

    @Override
    public Orders AddNewOrder(String doctorName, int orderNum, String rsvTime)
    {
        return orderDao.AddNewOrder(doctorName, orderNum, rsvTime);
    }
}
