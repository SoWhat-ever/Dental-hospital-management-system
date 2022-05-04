package com.example.dentistbackend.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import javax.persistence.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@Entity
@Table(name = "registration")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "registerId")
public class Registration {
    @Id
    @Column(name = "ID_r")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//挂号编号采用自增策略
    private int registerId;

    private int patientId;
    private int doctorId;
    private String rsvTime;
    private String GrabTime;
    private int State;

    public static Lock lock = new ReentrantLock();

    @Id
    @Column(name = "ID_r")
    public int getRegisterId()
    {
        return this.registerId;
    }
    public void setRegisterId(Integer id)
    {
        this.registerId = id;
    }

    @Basic
    @Column(name = "ID_p")
    public int getPatientId()
    {
        return this.patientId;
    }

    public void setPatientId(int id)
    {
        this.patientId = id;
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
    @Column(name = "time_rsv")
    public String getRsvTime()
    {
        return this.rsvTime;
    }
    public void setRsvTime(String rsvtime)
    {
        this.rsvTime = rsvtime;
    }

    @Basic
    @Column(name = "time_grab")
    public String getGrabTime()
    {
        return this.GrabTime;
    }

    public void setGrabTime(String grabtime)
    {
        this.GrabTime = grabtime;
    }

    @Basic
    @Column(name = "state")
    public int getState()
    {
        return this.State;
    }

    public void setState(int s)
    {
        this.State = s;
    }


}
