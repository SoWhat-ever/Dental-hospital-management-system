package com.example.dentistbackend.dao;
import com.example.dentistbackend.entity.Patient;
import java.util.List;
public interface PatientDao {
    Patient findOne(Integer id);
    List<Patient> getPatients();
    Patient checkUser(String username, String password);
}
