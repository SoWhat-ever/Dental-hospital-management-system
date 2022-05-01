package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.PatientDao;
import com.example.dentistbackend.entity.Patient;
import com.example.dentistbackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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

    @Override
    public Patient getPatientByName(String name)
    {
        List<Patient> list = PatientRepository.getPatientByName(name);
        Iterator<Patient> iter = list.iterator();
        int id = -1;
        while(iter.hasNext()){
            Patient p = iter.next();
            id = p.getPatientId();
            break;
        }
        if(id == -1){
            System.out.println("Not Found!");
            return null;
        }
        System.out.println("Success!");
        Patient p = findOne(id);
        System.out.println(p.getUsername());
        System.out.println(p.getPassword());
        System.out.println(p.getSex());
        System.out.println(p.getAge());
        return p;
    }

    @Override
    public Patient RegisterNewPatient(String name, String sex, int age, String username, String password
    ,String cardNum)
    {
        List<Patient> list = PatientRepository.getPatients();
        for(Patient patient : list){//检查用户名是否重复
            if(Objects.equals(patient.getUsername(), username)){
                System.out.println("用户名已存在！");
                return null;
            }
        }
        Patient p = new Patient();
        p.setName(name);
        p.setAge(age);
        p.setUsername(username);
        p.setPassword(password);
        p.setSex(sex);
        p.setCardNum(cardNum);
        System.out.println("Success!");
        PatientRepository.save(p);
        return p;
    }
}
