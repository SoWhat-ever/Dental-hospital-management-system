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
    public Registration AddNewReg(String doctorName, String patientName, String Time, int state)
    {
        return regDao.AddNewRegInfo(doctorName, patientName, Time, state);
    }

    @Override
    public List<Registration> getPatientOrders(String Name)
    {
        return regDao.getPatientOrders(Name);
    }

    @Override
    public List<Registration> getDoctorOrders(String Name)
    {
        return regDao.getDoctorOrders(Name);
    }

    @Override
    public Registration deleteReg(String patientName, String doctorName, String rsvTime)
    {
        return regDao.deleteReg(patientName, doctorName, rsvTime);
    }
}
