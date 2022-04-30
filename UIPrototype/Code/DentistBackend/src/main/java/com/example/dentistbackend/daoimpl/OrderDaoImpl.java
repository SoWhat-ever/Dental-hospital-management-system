package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.OrderDao;
import com.example.dentistbackend.entity.Orders;
import com.example.dentistbackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class OrderDaoImpl implements OrderDao{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Orders> getOrders(int doctorId, String RsvTime)
    {
        return orderRepository.getOrders(doctorId, RsvTime);
    }
}
