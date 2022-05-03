package com.example.dentistbackend.repository;
import com.example.dentistbackend.entity.Arrangement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface ArrangeRepository extends JpaRepository<Arrangement,Integer>{
    @Query("select b from Arrangement b")
    List<Arrangement> getArrangements();

    @Query(value = "from Arrangement where doctorId = :ID_d")
    List<Arrangement> getDoctorArrangement(@Param("ID_d") int doctorId);

    @Query(value = "from Arrangement where weekday = :weekday")
    List<Arrangement> getWeekdayArrangement(@Param("weekday") String weekday);
}
