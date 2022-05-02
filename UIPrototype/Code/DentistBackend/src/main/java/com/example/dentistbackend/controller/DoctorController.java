package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/getDoctors")
    @CrossOrigin
    public @ResponseBody List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }

    @RequestMapping("/getDoctor")
    @CrossOrigin
    public @ResponseBody Doctor getDoctor(@RequestParam("name") String name){
        return doctorService.findDoctorByName(name);
    }

    @RequestMapping("/checkDoctor")
    @CrossOrigin
    public @ResponseBody Doctor checkUser(@RequestParam("username")String username, @RequestParam("password") String password)
    {
        return doctorService.checkUser(username, password);
    }

    @RequestMapping("/updateDoctor")
    @CrossOrigin
    public @ResponseBody Doctor updateDoctor(@RequestParam("name") String doctorName, @RequestParam("username") String username,
                                             @RequestParam("password") String password, @RequestParam("title") String title,
                                             @RequestParam("description") String description, @RequestParam("image") String image)
    {
        return doctorService.updateDoctor(doctorName, username,
                password, title, description, image);
    }
}
