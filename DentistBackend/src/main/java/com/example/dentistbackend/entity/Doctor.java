package com.example.dentistbackend.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "doctor")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "doctorId")
public class Doctor {
    @Id
    @Column(name = "ID_d")
    private int doctorId;

    private String Username;
    private String Password;
    private String Image;
    private String Dept_name;
    private String Description;

    @Id
    @Column(name = "ID_d")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getDoctorId()
    {
        return this.doctorId;
    }

    public void setDoctorId(int id)
    {
        this.doctorId = id;
    }

    public String getUsername()
    {
        return this.Username;
    }

    public void setUsername(String name)
    {
        this.Username = name;
    }

    public String getPassword()
    {
        return this.Password;
    }

    public void setPassword(String pwd)
    {
        this.Password = pwd;
    }
}
