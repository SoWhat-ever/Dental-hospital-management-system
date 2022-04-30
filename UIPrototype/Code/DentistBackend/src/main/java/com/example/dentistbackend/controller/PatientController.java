package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Patient;
import com.example.dentistbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
@RestController
public class PatientController {
    @Autowired
    private PatientService PatientService;
    @RequestMapping("/getPatients")
    public List<Patient> getPatients() {
        return PatientService.getPatients();
    }

    @RequestMapping("/getPatient")
    public Patient getPatient(@RequestParam("id") Integer id){
        return PatientService.findPatientById(id);
    }

    @RequestMapping("/checkPatient")
    public Patient checkUser(@RequestParam("username")String username, @RequestParam("password") String password)
    {
        return PatientService.checkUser(username, password);
    }
}
