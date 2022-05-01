package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Patient;
import com.example.dentistbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
public class PatientController {
    @Autowired
    private PatientService PatientService;
    @RequestMapping("/getPatients")
    public @ResponseBody List<Patient> getPatients() {
        return PatientService.getPatients();
    }

    @RequestMapping("/getPatient")
    public @ResponseBody Patient getPatient(@RequestParam("name") String name){
        return PatientService.findPatientByName(name);
    }

    @RequestMapping("/checkPatient")
    public @ResponseBody Patient checkUser(@RequestParam("username")String username, @RequestParam("password") String password)
    {
        return PatientService.checkUser(username, password);
    }

    @RequestMapping("/registerPatient")
    public @ResponseBody Patient RegisterNewPatient(@RequestParam("name") String name, @RequestParam("sex") String sex,
                                      @RequestParam("age") int age, @RequestParam("username") String username,
                                      @RequestParam("password") String password,
                                      @RequestParam("cardnum") String cardNum)
    {
        return PatientService.registerNewPatient(name, sex, age, username, password, cardNum);
    }
}
