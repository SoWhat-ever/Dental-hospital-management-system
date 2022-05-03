package com.example.dentistbackend.repository;
import com.example.dentistbackend.entity.Doctor;
import com.example.dentistbackend.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface OrderRepository extends JpaRepository<Orders,Integer>{
    @Query(value = "from Orders where doctorId = :ID_d and rsvTime = :time_rsv")
    List<Orders> getOrders(@Param("ID_d") int doctorId, @Param("time_rsv") String RsvTime);

    @Query(value = "from Orders where doctorId = :ID_d")
    List<Orders> getDoctorOrder(@Param("ID_d") int doctorId);
}
