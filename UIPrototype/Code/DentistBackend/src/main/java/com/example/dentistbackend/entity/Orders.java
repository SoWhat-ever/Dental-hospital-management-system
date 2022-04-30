package com.example.dentistbackend.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "orders")
//@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "doctorId")
@IdClass(Orders.class)
public class Orders implements Serializable {
    @Id
    @Column(name = "ID_d")
    int doctorId;
    @Id
    @Column(name = "time_rsv")
    String RsvTime;

    int OrderNum;
    public Orders(){}
    public Orders(int doctorId, String rsvtime, int ordernum)
    {
        this.doctorId = doctorId;
        this.RsvTime = rsvtime;
        this.OrderNum = ordernum;
    }

    @Override
    public boolean equals(Object O)
    {
        if(this == O) return true;
        if(O == null || getClass() != O.getClass()) return false;
        Orders that = (Orders)O;
        return Objects.equals(doctorId, this.doctorId) && Objects.equals(RsvTime, this.RsvTime)
                && Objects.equals(OrderNum, this.OrderNum);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(doctorId, OrderNum);
    }

    public int getDoctorId()
    {
        return this.doctorId;
    }

    public void setDoctorId(int id)
    {
        this.doctorId = id;
    }

    public String getRsvTime()
    {
        return this.RsvTime;
    }

    public void setRsvTime(String rsvtime)
    {
        this.RsvTime = rsvtime;
    }

    public int getOrderNum()
    {
        return this.OrderNum;
    }

    public void setOrderNum(int num)
    {
        this.OrderNum = num;
    }
}
