package com.example.dentistbackend.repository;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface PatientRepository extends JpaRepository<Patient,Integer>{
    @Query("select p from Patient p")
    List<Patient> getPatients();

    @Query(value = "from Patient where Username = :username and Password = :password")
    Patient checkUser(@Param("username") String username, @Param("password") String password);
}
