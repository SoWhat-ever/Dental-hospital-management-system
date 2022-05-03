package com.example.dentistbackend.service;
import com.example.dentistbackend.dao.PatientProcessDao;
import com.example.dentistbackend.entity.Process_p;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public interface PatientProcessService {
    List<Process_p> getPatientProcess(String patientName);

    Process_p updateComment(int regId, int step, String comment);
}
