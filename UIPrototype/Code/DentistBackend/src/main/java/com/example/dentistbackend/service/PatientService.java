package com.example.dentistbackend.service;
import com.example.dentistbackend.entity.Patient;
import java.util.List;
public interface PatientService {
    Patient findPatientById(Integer id);
    List<Patient> getPatients();
    Patient checkUser(String username, String password);
    Patient findPatientByName(String name);
    Patient registerNewPatient(String name, String sex, int age, String username, String password
            ,String cardNum);
}
