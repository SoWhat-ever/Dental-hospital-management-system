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
    @CrossOrigin
    public @ResponseBody List<Patient> getPatients() {
        return PatientService.getPatients();
    }

    @RequestMapping("/getPatient")
    @CrossOrigin
    public @ResponseBody Patient getPatient(@RequestParam("name") String name){
        return PatientService.findPatientByName(name);
    }

    @RequestMapping("/checkPatient")
    @CrossOrigin
    public @ResponseBody Patient checkUser(@RequestParam("username")String username, @RequestParam("password") String password)
    {
        return PatientService.checkUser(username, password);
    }

    @RequestMapping("/registerPatient")
    @CrossOrigin
    public @ResponseBody Patient RegisterNewPatient(@RequestParam("name") String name,
                                                    @RequestParam("sex") String sex,
                                                    @RequestParam("age") int age,
                                                    @RequestParam("username") String username,
                                                    @RequestParam("password") String password,
                                                    @RequestParam("cardnum") String cardNum)
    {
        return PatientService.registerNewPatient(name, sex, age, username, password, cardNum);
    }

    @RequestMapping("/updatePatient")
    @CrossOrigin
    public Patient updatePatient(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "sex", required = false, defaultValue = "") String sex,
                                 @RequestParam(name = "age", required = false, defaultValue = "0") int age,
                                 @RequestParam(name = "cardnum", required = false, defaultValue = "") String cardNum,
                                 @RequestParam(name = "username", required = false, defaultValue = "") String username,
                                 @RequestParam(name = "password", required = false, defaultValue = "") String password)
    {
        return PatientService.updatePatient(name, sex, age, cardNum, username, password);
    }
}
