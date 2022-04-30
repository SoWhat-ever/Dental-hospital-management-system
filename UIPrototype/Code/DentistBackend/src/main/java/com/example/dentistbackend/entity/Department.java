package com.example.dentistbackend.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "department")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "depName")
public class Department {
    @Id
    @Column(name = "dept_name")
    private String depName;
    private String position;
    private String Description;
    @Id
    @Column(name = "dept_name")
    public String getDepName()
    {
        return this.depName;
    }
    public void setDepName(String name)
    {
        this.depName = name;
    }
}
