package com.example.dentistbackend.service;
import com.example.dentistbackend.entity.Arrangement;
import java.util.List;
public interface ArrangeService {
    Arrangement findArrangeById(Integer id);

    List<Arrangement> getArrangements();
}
