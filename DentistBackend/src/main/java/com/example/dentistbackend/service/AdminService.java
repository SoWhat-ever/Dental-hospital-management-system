package com.example.dentistbackend.service;
import com.example.dentistbackend.entity.Admin;
import java.util.List;
public interface AdminService {
    Admin checkUser(String username, String password);
}
