package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Arrangement;
import com.example.dentistbackend.repository.ArrangeRepository;
import com.example.dentistbackend.service.ArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
public class ArrangeController {
    @Autowired
    private ArrangeService ArrangeService;
    @RequestMapping("/getArrangements")
    public @ResponseBody List<Arrangement> getArrangements(@RequestBody Map<String, String> params) {
        return ArrangeService.getArrangements();
    }

    @RequestMapping("/getArrangement")
    public @ResponseBody Arrangement getArrangement(@RequestParam("id") Integer id){
        return ArrangeService.findArrangeById(id);
    }

    @RequestMapping("/doctorArrangement")
    public @ResponseBody List<Arrangement> getDoctorArrangement(@RequestParam("name") String name)
    {
        return ArrangeService.getDoctorArrangement(name);
    }

    @RequestMapping("/weekdayArrangement")
    public @ResponseBody List<Arrangement> getWeekdayArrangement(@RequestParam("weekday") String weekday)
    {
        return ArrangeService.getWeekdayArrangement(weekday);
    }
}
