package com.example.dentistbackend.dao;
import com.example.dentistbackend.entity.Admin;
import com.example.dentistbackend.entity.Doctor;

import java.util.List;
public interface AdminDao {
    Admin checkUser(String username, String password);
}
