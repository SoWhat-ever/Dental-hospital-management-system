package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/getDoctors")
    public List<Doctor> getDoctors(@RequestBody Map<String, String> params) {
        return doctorService.getDoctors();
    }

    @RequestMapping("/getDoctor")
    public Doctor getDoctor(@RequestParam("id") Integer id){
        return doctorService.findDoctorById(id);
    }
}
