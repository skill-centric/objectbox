package com.skill_centric.objectbox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Student extends Person {

    @Id
    private long id;
    private double grade;

    public Student(){
    }

    public Student(long id, String firstName, String lastName, double grade) {

        super(firstName, lastName);

        this.id = id;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", grade=" + grade +
                '}';
    }
}