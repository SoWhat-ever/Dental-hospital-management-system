package com.example.dentistbackend.service;
import com.example.dentistbackend.entity.Registration;
public interface RegService {
    Registration AddNewReg(int doctorId, int patientId, String Time, int state);
}
