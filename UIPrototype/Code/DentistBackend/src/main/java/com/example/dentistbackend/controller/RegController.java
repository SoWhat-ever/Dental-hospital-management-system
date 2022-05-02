package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Registration;
import com.example.dentistbackend.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
public class RegController {
    @Autowired
    private RegService regService;

    @RequestMapping("/regRequest")
    @CrossOrigin
    public @ResponseBody Registration AddNewReg
            (@RequestParam("doctorName") String doctorName, @RequestParam("patientName") String patientName,
             @RequestParam("time") String Time, @RequestParam("state") int state)
    {
        return regService.AddNewReg(doctorName, patientName, Time, state);
    }

    @RequestMapping("/patientOrders")
    @CrossOrigin
    public @ResponseBody List<Registration> getPatientOrders(@RequestParam("name") String patientName)
    {
        return regService.getPatientOrders(patientName);
    }

    @RequestMapping("/doctorOrders")
    @CrossOrigin
    public @ResponseBody List<Registration> getDoctorOrders(@RequestParam("name") String doctorName)
    {
        return regService.getDoctorOrders(doctorName);
    }
}
