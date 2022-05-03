package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Process_p;
import com.example.dentistbackend.service.PatientProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class PatientProcessController {
    @Autowired
    private PatientProcessService patientProcessService;

    @RequestMapping("/getPatientProcess")
    @CrossOrigin
    public @ResponseBody List<Process_p> getPatientProcess(@RequestParam("name") String patientName)
    {
        return patientProcessService.getPatientProcess(patientName);
    }

    @RequestMapping("/updateComment")
    @CrossOrigin
    public @ResponseBody Process_p updateComment(@RequestParam("id") int regId,
                                                 @RequestParam("step") int step,
                                                 @RequestParam(name = "comment", required = false, defaultValue = "") String comment)
    {
        return patientProcessService.updateComment(regId, step, comment);
    }
}
