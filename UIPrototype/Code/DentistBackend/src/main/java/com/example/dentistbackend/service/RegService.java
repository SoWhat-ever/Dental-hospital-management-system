package com.example.dentistbackend.service;
import com.example.dentistbackend.entity.Registration;

import java.util.List;

public interface RegService {
    Registration AddNewReg(String doctorName, String patientName, String Time, int state);

    List<Registration> getPatientOrders(String Name);

    List<Registration> getDoctorOrders(String Name);
}
