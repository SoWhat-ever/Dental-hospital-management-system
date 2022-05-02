package com.example.dentistbackend.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "arrangement")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "arrangeId")
public class Arrangement {
    @Id
    @Column(name = "number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int arrangeId;
    private String weekday;
    private String startTime;
    private String endTime;
    private int doctorId;
    private String deptName;

    @Id
    @Column(name = "number")
    public int getArrangeId()
    {
        return this.arrangeId;
    }
    public void setArrangeId(int id)
    {
        this.arrangeId = id;
    }

    @Basic
    @Column(name = "weekday")
    public String getWeekday()
    {
        return this.weekday;
    }
    public void setWeekday(String day)
    {
        this.weekday = day;
    }

    @Basic
    @Column(name = "time_start")
    public String getStartTime()
    {
        return this.startTime;
    }
    public void setStartTime(String time)
    {
        this.startTime = time;
    }

    @Basic
    @Column(name = "time_end")
    public String getEndTime()
    {
        return this.endTime;
    }
    public void setEndTime(String time)
    {
        this.endTime = time;
    }

    @Basic
    @Column(name = "ID_d")
    public int getDoctorId()
    {
        return this.doctorId;
    }
    public void setDoctorId(int id)
    {
        this.doctorId = id;
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
}
