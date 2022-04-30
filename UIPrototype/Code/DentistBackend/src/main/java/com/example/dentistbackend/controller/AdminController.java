package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Admin;
import com.example.dentistbackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
@RestController
public class AdminController {
    @Autowired
    private AdminService AdminService;

    @RequestMapping("/checkAdmin")
    public Admin checkUser(@RequestParam("username")String username, @RequestParam("password")String password)
    {
        return AdminService.checkUser(username, password);
    }
}
