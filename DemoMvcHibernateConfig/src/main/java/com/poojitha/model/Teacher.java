package com.poojitha.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teacher_Id;

    private String teacher_Name;

    private String className;

    private String teacher_Gender;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="teacher_id")
    private List<Student> students = new ArrayList<Student>();

    public Teacher() {
    }

    public Teacher(String teacher_Name, String className, String teacher_Gender, List<Student> students) {
        this.teacher_Name = teacher_Name;
        this.className = className;
        this.teacher_Gender = teacher_Gender;
        this.students = students;
    }

    public long getTeacher_Id() {
        return teacher_Id;
    }

    public void setTeacher_Id(long teacher_Id) {
        this.teacher_Id = teacher_Id;
    }

    public String getTeacher_Name() {
        return teacher_Name;
    }

    public void setTeacher_Name(String teacher_Name) {
        this.teacher_Name = teacher_Name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacher_Gender() {
        return teacher_Gender;
    }

    public void setTeacher_Gender(String teacher_Gender) {
        this.teacher_Gender = teacher_Gender;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher [teacher_Id=" + teacher_Id + ", teacher_Name=" + teacher_Name + ", className=" + className
                + ", teacher_Gender=" + teacher_Gender + ", students=" + students + "]";
    }
}