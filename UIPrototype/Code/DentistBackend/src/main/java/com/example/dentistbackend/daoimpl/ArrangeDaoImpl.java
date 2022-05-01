package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.ArrangeDao;
import com.example.dentistbackend.entity.Arrangement;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.repository.ArrangeRepository;
import com.example.dentistbackend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class ArrangeDaoImpl implements ArrangeDao {
    @Autowired
    private ArrangeRepository ArrangeRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Arrangement findOne(Integer id)
    {
        return ArrangeRepository.getOne(id);
    }

    @Override
    public List<Arrangement> getArrangements()
    {
        return ArrangeRepository.getArrangements();
    }

    @Override
    public List<Arrangement> getDoctorArrangement(String doctorName)
    {
        List<Doctor> list1 = doctorRepository.getDoctorByName(doctorName);
        int doctorId = -1;
        for(Doctor d : list1){
            doctorId = d.getDoctorId();
            break;
        }
        if(doctorId == -1){
            System.out.println("Can't find the corresponding doctor!");
            return null;
        }
        return ArrangeRepository.getDoctorArrangement(doctorId);
    }

    @Override
    public List<Arrangement> getWeekdayArrangement(String weekday)
    {
        return ArrangeRepository.getWeekdayArrangement(weekday);
    }
}
