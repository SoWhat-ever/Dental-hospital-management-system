package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Arrangement;
import com.example.dentistbackend.repository.ArrangeRepository;
import com.example.dentistbackend.service.ArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
@RestController
public class ArrangeController {
    @Autowired
    private ArrangeService ArrangeService;
    @RequestMapping("/getArrangements")
    public List<Arrangement> getArrangements(@RequestBody Map<String, String> params) {
        return ArrangeService.getArrangements();
    }

    @RequestMapping("/getArrangement")
    public Arrangement getArrangement(@RequestParam("id") Integer id){
        return ArrangeService.findArrangeById(id);
    }
}
