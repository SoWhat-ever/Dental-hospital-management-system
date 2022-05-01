package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.DoctorDao;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
@Repository
public class DoctorDaoImpl implements DoctorDao{
    @Autowired
    private DoctorRepository DoctorRepository;

    @Override
    public Doctor findOne(Integer id){
        return DoctorRepository.getOne(id);
    }

    @Override
    public List<Doctor> getDoctors() {
        return DoctorRepository.getDoctors();
    }

    @Override
    public Doctor checkUser(String username, String password)
    {
        return DoctorRepository.checkUser(username, password);
    }

    @Override
    public Doctor getDoctorByName(String name)
    {
        List<Doctor> list = DoctorRepository.getDoctorByName(name);
        Integer id = -1;
        Iterator<Doctor> iter = list.iterator();
        while(iter.hasNext()){
            Doctor d = iter.next();
            id = d.getDoctorId();
            break;
        }
        if(id == -1){
            System.out.println("Not Found!");
            return null;
        }
        System.out.println("Success!");
        Doctor doctor = findOne(id);
        System.out.println(doctor.getDoctorId());
        System.out.println(doctor.getDeptName());
        System.out.println(doctor.getUsername());
        return doctor;
    }
}
