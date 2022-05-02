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
    @CrossOrigin
    public @ResponseBody List<Arrangement> getArrangements() {
        return ArrangeService.getArrangements();
    }

    @RequestMapping("/getArrangement")
    @CrossOrigin
    public @ResponseBody Arrangement getArrangement(@RequestParam("id") Integer id){
        return ArrangeService.findArrangeById(id);
    }

    @RequestMapping("/doctorArrangement")
    @CrossOrigin
    public @ResponseBody List<Arrangement> getDoctorArrangement(@RequestParam("name") String name)
    {
        return ArrangeService.getDoctorArrangement(name);
    }

    @RequestMapping("/weekdayArrangement")
    @CrossOrigin
    public @ResponseBody List<Arrangement> getWeekdayArrangement(@RequestParam("weekday") String weekday)
    {
        return ArrangeService.getWeekdayArrangement(weekday);
    }

    @RequestMapping("/addArrangement")
    @CrossOrigin
    public @ResponseBody Arrangement AddNewArrangement(@RequestParam("weekday") String weekday,
                                                       @RequestParam("starttime") String startTime,
                                                       @RequestParam("name") String doctorName,
                                                      @RequestParam("ordernum") int orderNum)
    {
        return ArrangeService.AddNewArrangement(weekday, startTime, doctorName, orderNum);
    }
}
