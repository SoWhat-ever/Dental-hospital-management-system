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
    private String Weekday;
    private int StartTime;
    private int EndTime;
    private int doctorId;
    //此处没有将表格中的dept_name作为一个属性写入
}
