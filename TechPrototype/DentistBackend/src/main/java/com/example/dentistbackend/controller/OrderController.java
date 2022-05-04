package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Orders;
import com.example.dentistbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/updateOrder")
    @CrossOrigin
    public @ResponseBody  Orders updateOrders(@RequestParam("doctorName") String doctorName,
                                              @RequestParam("ordernum") int orderNum,
                                              @RequestParam("rsvTime") String rsvTime)//这里只实现了对最大放号量的修改
    {
        return orderService.updateOrderInfo(doctorName, orderNum, rsvTime);
    }

    @RequestMapping("/addOrder")
    @CrossOrigin
    public @ResponseBody Orders AddNewOrder(@RequestParam("doctorName")String doctorName,
                                            @RequestParam("ordernum") int orderNum,
                                            @RequestParam("rsvTime") String rsvTime) throws ParseException {
        return orderService.AddNewOrder(doctorName, orderNum, rsvTime);
    }
}
