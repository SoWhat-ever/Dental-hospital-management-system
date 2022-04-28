package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.PatientDao;
import com.example.dentistbackend.entity.Patient;
import com.example.dentistbackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class PatientDaoImpl implements PatientDao{
    @Autowired
    private PatientRepository PatientRepository;

    @Override
    public Patient findOne(Integer id){
        return PatientRepository.getOne(id);
    }

    @Override
    public List<Patient> getPatients() {
        return PatientRepository.getPatients();
    }

    @Override
    public Patient checkUser(String username, String password)
    {
        return PatientRepository.checkUser(username, password);
    }
}
