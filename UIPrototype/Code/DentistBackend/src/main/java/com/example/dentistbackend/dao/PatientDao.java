package com.example.dentistbackend.dao;
import com.example.dentistbackend.entity.Patient;
import java.util.List;
public interface PatientDao {
    Patient findOne(Integer id);
    List<Patient> getPatients();
    Patient checkUser(String username, String password);
    Patient getPatientByName(String name);
    Patient RegisterNewPatient(String name, String sex, int age, String username, String password,
                               String cardNum);
}
