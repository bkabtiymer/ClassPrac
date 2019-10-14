package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    private long id;
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Classroom classroom;
    private String name;
    private String studentID;
    private String major;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "classid")
//    private Class class;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }




}
