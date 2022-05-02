package com.example.dentistbackend.service;
import com.example.dentistbackend.entity.Arrangement;
import java.util.List;
public interface ArrangeService {
    Arrangement findArrangeById(Integer id);

    List<Arrangement> getArrangements();

    List<Arrangement> getDoctorArrangement(String name);

    List<Arrangement> getWeekdayArrangement(String weekday);

    Arrangement AddNewArrangement(String weekday, String startTime, String doctorName,
                                  int orderNum);
}
