package com.example.dentistbackend.repository;
import com.example.dentistbackend.entity.Process_p;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface Process_p_Repository extends JpaRepository<Process_p,Integer> {
    @Query(value = "from Process_p where regId = :ID_r")
    List<Process_p> getProcessById(@Param("ID_r") int regId);

    @Query(value = "from Process_p where regId = :ID_r and step = :step")
    List<Process_p> getProcessInfo(@Param("ID_r") int regId, @Param("step") int step);

    @Query(value = "from Process_p where doctorId = :ID_d")
    List<Process_p> getProcessByDoctor(@Param("ID_d") int doctorId);
}
