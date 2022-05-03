package com.example.dentistbackend.daoimpl;
import com.example.dentistbackend.dao.AdminDao;
import com.example.dentistbackend.entity.Admin;
import com.example.dentistbackend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin checkUser(String username, String password)
    {
        return adminRepository.checkUser(username, password);
    }
}
