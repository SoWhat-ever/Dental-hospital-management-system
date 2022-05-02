package com.example.dentistbackend.serviceimpl;
import com.example.dentistbackend.dao.AdminDao;
import com.example.dentistbackend.entity.Admin;
import com.example.dentistbackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin checkUser(String username, String password)
    {
        Admin admin = adminDao.checkUser(username, password);
        if(isEmpty(admin)) System.out.println("Not Found!");
        else{
            System.out.println(admin.getAdminId());
            System.out.println(admin.getUsername());
            System.out.println(admin.getPassword());
        }
        return admin;
    }
}
