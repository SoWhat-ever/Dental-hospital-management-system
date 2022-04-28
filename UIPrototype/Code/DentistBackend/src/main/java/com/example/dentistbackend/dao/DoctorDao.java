package com.example.dentistbackend.dao;
import com.example.dentistbackend.entity.Doctor;
import java.util.List;
public interface DoctorDao {
    Doctor findOne(Integer id);
    List<Doctor> getDoctors();
    Doctor checkUser(String username, String password);
}
