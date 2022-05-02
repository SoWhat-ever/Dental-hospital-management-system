package com.example.dentistbackend.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "admin")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "adminId")
public class Admin {
    @Id
    @Column(name = "ID_a")
    private int adminId;

    private String Username;
    private String Password;

    @Id
    @Column(name = "ID_a")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAdminId()
    {
        return this.adminId;
    }

    public void setAdminId(int id)
    {
        this.adminId = id;
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
}
