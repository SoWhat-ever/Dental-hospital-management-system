package com.example.dentistbackend.repository;
import com.example.dentistbackend.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface AdminRepository extends JpaRepository<Admin,Integer>{
    @Query(value = "from Admin where Username = :username and Password = :password")
    Admin checkUser(@Param("username") String username, @Param("password") String password);
}
