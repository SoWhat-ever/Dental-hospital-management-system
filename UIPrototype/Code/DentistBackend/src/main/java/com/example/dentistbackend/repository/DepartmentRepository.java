package com.example.dentistbackend.repository;
import com.example.dentistbackend.entity.Department;
import com.example.dentistbackend.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface DepartmentRepository extends JpaRepository<Department,Integer>{
    @Query("select d from Department d")
    List<Department> getDepartments();//获取所有的科室信息
}
