package com.example.dentistbackend.dao;
import com.example.dentistbackend.entity.Process_p;
import java.util.List;
public interface PatientProcessDao {
    List<Process_p> getPatientProcess(String patientName);

    Process_p updateComment(int regId, int step, String comment);
}
