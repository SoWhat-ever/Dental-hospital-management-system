package com.example.dentistbackend.repository;
import com.example.dentistbackend.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    @Query("select d from Doctor d")
    List<Doctor> getDoctors();

    @Query(value = "from Doctor where name = :name")
    List<Doctor> getDoctorByName(@Param("name") String name);

    @Query(value = "from Doctor where Username = :username and Password = :password")
    Doctor checkUser(@Param("username") String name, @Param("password") String password);
}
