package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.DepartmentDao;
import com.example.dentistbackend.entity.Department;
import com.example.dentistbackend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Repository
public class DepartmentDaoImpl implements DepartmentDao{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepartments()
    {
        return departmentRepository.getDepartments();
    }
}
