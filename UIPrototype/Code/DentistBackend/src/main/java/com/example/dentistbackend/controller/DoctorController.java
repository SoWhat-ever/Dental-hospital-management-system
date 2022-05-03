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
    public @ResponseBody List<Doctor> getDoctors()
    {
        return doctorService.getDoctors();
    }

    @RequestMapping("/getDoctor")
    @CrossOrigin
    public @ResponseBody Doctor getDoctor(@RequestParam("name") String name)
    {
        return doctorService.findDoctorByName(name);
    }

    @RequestMapping("/checkDoctor")
    @CrossOrigin
    public @ResponseBody Doctor checkUser(@RequestParam("username")String username, @RequestParam("password") String password)
    {
        return doctorService.checkUser(username, password);
    }

    @RequestMapping("/updateDoctor")//更新医生信息
    @CrossOrigin
    public @ResponseBody Doctor updateDoctor(@RequestParam(name = "name") String doctorName,
                                             @RequestParam(name = "username", required = false, defaultValue = "") String username,
                                             @RequestParam(name = "password", required = false, defaultValue = "") String password,
                                             @RequestParam(name = "title", required = false, defaultValue = "") String title,
                                             @RequestParam(name = "description", required = false, defaultValue = "") String description,
                                             @RequestParam(name = "image", required = false, defaultValue = "") String image)
    {
        return doctorService.updateDoctor(doctorName, username,
                password, title, description, image);
    }

    @RequestMapping("/addDoctor")//添加医生信息
    @CrossOrigin
    public @ResponseBody Doctor addDoctor(@RequestParam(name = "name") String doctorName,
                                          @RequestParam(name = "username") String username,
                                          @RequestParam(name = "password") String password,
                                          @RequestParam(name = "title") String title,
                                          @RequestParam(name = "description") String description,
                                          @RequestParam(name = "dept") String deptName,
                                          @RequestParam(name = "image") String image)
    {
        return doctorService.addDoctor(doctorName, username, password, title, description, deptName, image);
    }

    @RequestMapping("/delDoctor")//删除一个医生的信息
    @CrossOrigin
    public @ResponseBody Doctor deleteDoctor(@RequestParam(name = "name")String doctorName)
    {
        return doctorService.deleteDoctor(doctorName);
    }
}
