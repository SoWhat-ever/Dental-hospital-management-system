package com.example.dentistbackend.service;
import com.example.dentistbackend.entity.Orders;

import java.text.ParseException;

public interface OrderService {
    Orders updateOrderInfo(String doctorName, int orderNum, String rsvTime);

    Orders AddNewOrder(String doctorName, int orderNum, String rsvTime) throws ParseException;
}
