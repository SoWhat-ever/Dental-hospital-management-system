package com.example.dentistbackend.service;
import com.example.dentistbackend.entity.Doctor;
import java.util.List;
public interface DoctorService {
    Doctor findDoctorById(Integer id);
    List<Doctor> getDoctors();
    Doctor checkUser(String name, String password);
    Doctor findDoctorByName(String name);
    Doctor updateDoctor(String doctorName, String username, String password,
                        String title, String description, String image);
    Doctor addDoctor(String doctorName, String username, String password,
                     String title, String description, String deptName, String image);
    Doctor deleteDoctor(String doctorName);
}
