package com.example.dentistbackend.serviceimpl;
import com.example.dentistbackend.dao.ArrangeDao;
import com.example.dentistbackend.dao.DoctorDao;
import com.example.dentistbackend.entity.Arrangement;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.service.ArrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ArrangeServiceImpl implements ArrangeService{
    @Autowired
    private ArrangeDao ArrangeDao;
    @Override
    public Arrangement findArrangeById(Integer id){
        return ArrangeDao.findOne(id);
    }

    @Override
    public List<Arrangement> getArrangements() {
        return ArrangeDao.getArrangements();
    }
}
