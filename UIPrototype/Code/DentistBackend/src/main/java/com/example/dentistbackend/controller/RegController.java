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
    public @ResponseBody Registration AddNewReg
            (@RequestParam("doctorId") int doctorId, @RequestParam("patientId") int patientId,
             @RequestParam("time") String Time, @RequestParam("state") int state)
    {
        return regService.AddNewReg(doctorId, patientId, Time, state);
    }
}
