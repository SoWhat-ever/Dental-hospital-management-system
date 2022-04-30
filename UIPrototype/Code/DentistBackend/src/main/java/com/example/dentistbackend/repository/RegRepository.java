package com.example.dentistbackend.repository;
import com.example.dentistbackend.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface RegRepository extends JpaRepository<Registration,Integer>{
    @Query(value = "from Registration where doctorId = :ID_d and rsvTime = :time_rsv")
    List<Registration> getCurOrders(@Param("ID_d") int ID_d, @Param("time_rsv") String time_rsv);
}
