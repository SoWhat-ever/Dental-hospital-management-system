package com.example.dentistbackend.serviceimpl;
import com.example.dentistbackend.dao.RegDao;
import com.example.dentistbackend.entity.Registration;
import com.example.dentistbackend.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;

@Service
public class RegServiceImpl implements RegService{
    @Autowired
    private RegDao regDao;

    @Override
    public Registration AddNewReg(int doctorId, int patientId, String Time, int state)
    {
        return regDao.AddNewReg(doctorId, patientId, Time, state);
    }
}
