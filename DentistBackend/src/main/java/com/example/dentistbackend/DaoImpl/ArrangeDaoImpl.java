package com.example.dentistbackend.DaoImpl;
import com.example.dentistbackend.dao.ArrangeDao;
import com.example.dentistbackend.entity.Arrangement;
import com.example.dentistbackend.repository.ArrangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class ArrangeDaoImpl implements ArrangeDao {
    @Autowired
    private ArrangeRepository ArrangeRepository;

    @Override
    public Arrangement findOne(Integer id){
        return ArrangeRepository.getOne(id);
    }

    @Override
    public List<Arrangement> getArrangements() {
        return ArrangeRepository.getArrangements();
    }
}
