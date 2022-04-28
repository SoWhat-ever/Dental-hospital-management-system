package com.example.dentistbackend.service;
import com.example.dentistbackend.entity.Patient;
import java.util.List;
public interface PatientService {
    Patient findPatientById(Integer id);
    List<Patient> getPatients();
    Patient checkUser(String username, String password);
}
