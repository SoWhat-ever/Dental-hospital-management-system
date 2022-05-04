package com.example.dentistbackend.serviceimpl;
import com.example.dentistbackend.dao.DepartmentDao;
import com.example.dentistbackend.entity.Department;
import com.example.dentistbackend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getDepartments()
    {
        return departmentDao.getDepartments();
    }
}
