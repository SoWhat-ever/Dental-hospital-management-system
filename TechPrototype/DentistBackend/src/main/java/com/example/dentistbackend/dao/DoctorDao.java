package com.example.dentistbackend.dao;
import com.example.dentistbackend.entity.Doctor;
import java.util.List;
public interface DoctorDao {
    Doctor findOne(Integer id);
    List<Doctor> getDoctors();
    Doctor checkUser(String username, String password);
    Doctor getDoctorByName(String name);
    Doctor updateDoctor(String doctorName, String username, String password,
                        String title, String description, String image);
    Doctor addDoctor(String doctorName, String username, String password,
                     String title, String description, String deptName, String image);
    Doctor deleteDoctor(String doctorName);
}
