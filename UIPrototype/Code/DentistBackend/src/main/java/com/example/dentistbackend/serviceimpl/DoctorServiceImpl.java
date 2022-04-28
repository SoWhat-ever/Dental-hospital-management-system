package com.example.dentistbackend.serviceimpl;
import com.example.dentistbackend.dao.DoctorDao;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorDao doctorDao;
    @Override
    public Doctor findDoctorById(Integer id){
        return doctorDao.findOne(id);
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctorDao.getDoctors();
    }

    @Override
    public Doctor checkUser(String username, String password)
    {
        return doctorDao.checkUser(username, password);
    }
}
