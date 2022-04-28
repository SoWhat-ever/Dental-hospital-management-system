package com.example.dentistbackend.DaoImpl;
import com.example.dentistbackend.dao.AdminDao;
import com.example.dentistbackend.entity.Admin;
import com.example.dentistbackend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class AdminDaoImpl implements AdminDao{
    @Autowired
    private AdminRepository AdminRepository;

    @Override
    public Admin checkUser(String username, String password)
    {
        return AdminRepository.checkUser(username, password);
    }
}
