package com.example.dentistbackend.repository;
import com.example.dentistbackend.entity.Arrangement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ArrangeRepository extends JpaRepository<Arrangement,Integer>{
    @Query("select b from Arrangement b")
    List<Arrangement> getArrangements();
}
