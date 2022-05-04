package com.example.dentistbackend.controller;
import com.example.dentistbackend.entity.Department;
import com.example.dentistbackend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/getDepartments")
    @CrossOrigin
    public @ResponseBody List<Department> getDepartments()
    {
        return departmentService.getDepartments();
    }
}
