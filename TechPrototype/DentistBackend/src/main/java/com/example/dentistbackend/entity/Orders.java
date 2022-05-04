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

    int orderNum;
    public Orders(){}
    public Orders(int doctorId, String rsvtime, int ordernum)
    {
        this.doctorId = doctorId;
        this.RsvTime = rsvtime;
        this.orderNum = ordernum;
    }

    @Override
    public boolean equals(Object O)
    {
        if(this == O) return true;
        if(O == null || getClass() != O.getClass()) return false;
        Orders that = (Orders)O;
        return Objects.equals(doctorId, this.doctorId) && Objects.equals(RsvTime, this.RsvTime)
                && Objects.equals(orderNum, this.orderNum);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(doctorId, orderNum);
    }

    @Id
    @Column(name = "ID_d")
    public int getDoctorId()
    {
        return this.doctorId;
    }

    public void setDoctorId(int id)
    {
        this.doctorId = id;
    }

    @Id
    @Column(name = "time_rsv")
    public String getRsvTime()
    {
        return this.RsvTime;
    }

    public void setRsvTime(String rsvtime)
    {
        this.RsvTime = rsvtime;
    }

    @Basic
    @Column(name = "order_num")
    public int getOrderNum()
    {
        return this.orderNum;
    }

    public void setOrderNum(int num)
    {
        this.orderNum = num;
    }
}
