package com.example.dentistbackend.dao;
import com.example.dentistbackend.entity.Arrangement;

import java.util.List;
public interface ArrangeDao {
    Arrangement findOne(Integer id);
    List<Arrangement> getArrangements();
    List<Arrangement> getDoctorArrangement(String doctorName);
    List<Arrangement> getWeekdayArrangement(String weekday);
}
