package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.DoctorDao;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
}
