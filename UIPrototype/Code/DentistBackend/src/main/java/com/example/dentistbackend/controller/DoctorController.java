package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/getDoctors")
    public @ResponseBody List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }

    @RequestMapping("/getDoctor")
    public @ResponseBody Doctor getDoctor(@RequestParam("name") String name){
        return doctorService.findDoctorByName(name);
    }

    @RequestMapping("/checkDoctor")
    public @ResponseBody Doctor checkUser(@RequestParam("username")String username, @RequestParam("password") String password)
    {
        return doctorService.checkUser(username, password);
    }
}
