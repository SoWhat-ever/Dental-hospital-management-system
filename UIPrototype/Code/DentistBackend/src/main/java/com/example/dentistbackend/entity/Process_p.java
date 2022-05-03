package com.example.dentistbackend.entity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "process_p")
@IdClass(Process_p.class)
public class Process_p implements Serializable {
    @Id
    @Column(name = "ID_r")
    private int regId;
    @Id
    @Column(name = "step")
    private int step;

    private String disease;
    private int doctorId;
    private String content;
    private String comment;

    @Override
    public boolean equals(Object O)
    {
        if(this == O) return true;
        if(O == null || getClass() != O.getClass()) return false;
        Process_p that = (Process_p)O;
        return Objects.equals(that.doctorId, this.doctorId) && Objects.equals(that.regId, this.regId)
                && Objects.equals(that.step, this.step) && Objects.equals(that.disease, this.disease)
                && Objects.equals(that.content, this.content) && Objects.equals(that.comment, this.comment);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(doctorId, step);
    }

    @Id
    @Column(name = "ID_r")
    public int getRegId()
    {
        return this.regId;
    }
    public void setRegId(int id)
    {
        this.regId = id;
    }
    @Id
    @Column(name = "step")
    public int getStep()
    {
        return this.step;
    }
    public void setStep(int step)
    {
        this.step = step;
    }

    @Basic
    @Column(name = "disease_name")
    public String getDisease()
    {
        return this.disease;
    }
    public void setDisease(String d)
    {
        this.disease = d;
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
    @Column(name = "content")
    public String getContent()
    {
        return this.content;
    }
    public void setContent(String c)
    {
        this.content = c;
    }
    @Basic
    @Column(name = "comment")
    public String getComment()
    {
        return this.comment;
    }
    public void setComment(String comment)
    {
        this.comment = comment;
    }
}
