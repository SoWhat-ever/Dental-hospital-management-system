package com.example.dentistbackend.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patient")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "patientId")
public class Patient {
    @Id
    @Column(name = "ID_p")
    private int patientId;

    private String name;
    private String sex;
    private int age;
    private String cardNum;
    private String Username;
    private String Password;

    @Id
    @Column(name = "ID_p")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPatientId()
    {
        return this.patientId;
    }

    public void setPatientId(int id)
    {
        this.patientId = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername()
    {
        return this.Username;
    }

    public void setUsername(String name)
    {
        this.Username = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword()
    {
        return this.Password;
    }

    public void setPassword(String pwd)
    {
        this.Password = pwd;
    }

    @Basic
    @Column(name = "sex")
    public String getSex()
    {
        return this.sex;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age")
    public int getAge()
    {
        return this.age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    @Basic
    @Column(name = "IDCard")
    public String getCardNum()
    {
        return this.cardNum;
    }
    public void setCardNum(String cardNum)
    {
        this.cardNum = cardNum;
    }
}
