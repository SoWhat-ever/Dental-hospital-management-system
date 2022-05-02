package com.example.dentistbackend.serviceimpl;
import com.example.dentistbackend.dao.PatientDao;
import com.example.dentistbackend.entity.Patient;
import com.example.dentistbackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

import static org.springframework.util.ObjectUtils.*;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientDao PatientDao;
    @Override
    public Patient findPatientById(Integer id){
        Patient p =  PatientDao.findOne(id);
        System.out.println(p.getPatientId());
        System.out.println(p.getUsername());
        System.out.println(p.getPassword());
        return p;
    }

    @Override
    public List<Patient> getPatients() {
        List<Patient> list = PatientDao.getPatients();
        Iterator<Patient> iter = list.iterator();
        while(iter.hasNext()){
            Patient p = iter.next();
            System.out.println(p.getPatientId());
            System.out.println(p.getUsername());
            System.out.println(p.getPassword());
        }
        return list;
    }

    @Override
    public Patient checkUser(String username, String password)
    {
        Patient patient = PatientDao.checkUser(username, password);
        if(isEmpty(patient)) System.out.println("Not Found!");
        else{
            System.out.println(patient.getPatientId());
            System.out.println(patient.getUsername());
            System.out.println(patient.getPassword());
        }
        return patient;
    }

    @Override
    public Patient findPatientByName(String name)
    {
        return PatientDao.getPatientByName(name);
    }

    @Override
    public Patient registerNewPatient(String name, String sex, int age, String username, String password
            ,String cardNum)
    {
        return PatientDao.RegisterNewPatient(name, sex, age, username, password, cardNum);
    }

    @Override
    public Patient updatePatient(String name, String sex, int age, String cardNum,
                                 String username, String password)
    {
        return PatientDao.updatePatient(name, sex, age, cardNum, username, password);
    }
}

