package com.example.dentistbackend.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "registration")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "registerId")
public class Registration {
    @Id
    @Column(name = "ID_r")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registerId;
    private int doctorId;
    private int patientId;
    private String State;
    private String RsvTime;
    private String GrabTime;
}
