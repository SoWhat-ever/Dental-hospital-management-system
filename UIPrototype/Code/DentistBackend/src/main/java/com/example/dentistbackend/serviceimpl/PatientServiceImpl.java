package com.example.dentistbackend.serviceimpl;
import com.example.dentistbackend.dao.PatientDao;
import com.example.dentistbackend.entity.Patient;
import com.example.dentistbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientDao PatientDao;
    @Override
    public Patient findPatientById(Integer id){
        return PatientDao.findOne(id);
    }

    @Override
    public List<Patient> getPatients() {
        return PatientDao.getPatients();
    }

    @Override
    public Patient checkUser(String username, String password)
    {
        return PatientDao.checkUser(username, password);
    }
}

