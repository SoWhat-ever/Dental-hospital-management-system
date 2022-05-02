package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Admin;
import com.example.dentistbackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
public class AdminController {
    @Autowired
    private AdminService AdminService;

    @RequestMapping("/checkAdmin")
    @CrossOrigin
    public @ResponseBody  Admin checkUser(@RequestParam("username")String username, @RequestParam("password")String password)
    {
        return AdminService.checkUser(username, password);
    }
}
