package com.example.dentistbackend.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private String Password;

    private String image;
    private String deptName;
    private String Description;
    private String name;//实际姓名
    private String title;

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
    @JsonIgnore
    public String getPassword()
    {
        return this.Password;
    }
    @JsonIgnore
    public void setPassword(String pwd)
    {
        this.Password = pwd;
    }

    @Basic
    @Column(name = "description")
    public String getDescription()
    {
        return this.Description;
    }

    public void setDescription(String description)
    {
        this.Description = description;
    }

    @Basic
    @Column(name = "dept_name")
    public String getDeptName()
    {
        return this.deptName;
    }
    public void setDeptName(String name)
    {
        this.deptName = name;
    }

    @Basic
    @Column(name = "name")
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "image")
    public String getImage()
    {
        return this.image;
    }
    public void setImage(String image)
    {
        this.image = image;
    }

    @Basic
    @Column(name = "title")
    public String getTitle()
    {
        return this.title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
}
