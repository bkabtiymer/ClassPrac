package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Classroom {
    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    private long classid;

    private String classname;
    private String professor;
    private String credit;
    private String description;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    public Set<Student> students;

    public long getClassid() {
        return classid;
    }

    public void setClassid(long classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
