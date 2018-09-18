package com.skill_centric.objectbox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Student extends Person {

    private double grade;

    public Student(){
    }

    public Student(long id, String firstName, String lastName, double grade) {

        super(id, firstName, lastName);

        this.grade = grade;
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
                "firstName=" + getFirstName() + ", " +
                "lastName=" + getLastName() + ", " +
                "grade=" + grade +
                '}';
    }
}