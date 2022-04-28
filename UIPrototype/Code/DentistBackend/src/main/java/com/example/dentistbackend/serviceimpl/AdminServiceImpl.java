package com.example.dentistbackend.serviceimpl;
import com.example.dentistbackend.dao.AdminDao;
import com.example.dentistbackend.entity.Admin;
import com.example.dentistbackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin checkUser(String username, String password)
    {
        return adminDao.checkUser(username, password);
    }
}
