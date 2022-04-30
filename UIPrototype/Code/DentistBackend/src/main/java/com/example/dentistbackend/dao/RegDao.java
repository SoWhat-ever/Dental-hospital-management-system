package com.example.dentistbackend.dao;
import com.example.dentistbackend.entity.Registration;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface RegDao {
    Registration AddNewReg(int doctorId, int patientId, String Time, int state);

    List<Registration> getCurOrders(int ID_d, String time_rsv);
}
