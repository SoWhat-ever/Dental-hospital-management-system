package com.example.dentistbackend.dao;
import com.example.dentistbackend.entity.Orders;

import java.util.List;

public interface OrderDao {
    List<Orders> getOrders(int doctorId, String RsvTime);

}
