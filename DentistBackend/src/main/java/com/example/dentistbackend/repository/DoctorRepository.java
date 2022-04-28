package com.example.dentistbackend.repository;
import com.example.dentistbackend.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    @Query("select b from Doctor b")
    List<Doctor> getDoctors();

    @Query(value = "from Doctor where Username = :name and Password = :password")
    Doctor checkUser(@Param("Username") String username, @Param("Password") String password);
}
