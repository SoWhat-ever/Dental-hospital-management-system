package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Registration;
import com.example.dentistbackend.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RegController {
    @Autowired
    private RegService regService;

    @RequestMapping("/regRequest")
    @CrossOrigin
    public @ResponseBody Registration AddNewReg
            (@RequestParam("doctorName") String doctorName,
             @RequestParam("patientName") String patientName,
             @RequestParam("time") String Time,
             @RequestParam(name = "state", required = false, defaultValue = "0") int state)
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

    @RequestMapping("/deleteReg")//患者推掉自己的某个诊号
    @CrossOrigin
    public @ResponseBody Registration deleteReg(@RequestParam("patientName") String patientName,
                                                @RequestParam("doctorName") String doctorName,
                                                @RequestParam("Time") String rsvTime)
    {
        return regService.deleteReg(patientName, doctorName, rsvTime);
    }
}
