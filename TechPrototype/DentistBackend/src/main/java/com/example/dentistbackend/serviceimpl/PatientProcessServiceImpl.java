package com.example.dentistbackend.serviceimpl;
import com.example.dentistbackend.dao.PatientProcessDao;
import com.example.dentistbackend.entity.Process_p;
import com.example.dentistbackend.service.PatientProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class PatientProcessServiceImpl implements PatientProcessService{
    @Autowired
    private PatientProcessDao patientProcessDao;

    @Override
    public List<Process_p> getPatientProcess(String patientName)
    {
        return patientProcessDao.getPatientProcess(patientName);
    }

    @Override
    public Process_p updateComment(int regId, int step, String comment)
    {
        return patientProcessDao.updateComment(regId, step, comment);
    }
}
