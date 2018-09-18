package com.skill_centric.objectbox;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Student {

    @Id
    private long id;

    private String firstName;
    private String lastName;
    private double grade;

    private ToOne<PassportDetails> passportDetails;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public ToOne<PassportDetails> getPassportDetails() {
        return passportDetails;
    }

    public void setPassportDetails(ToOne<PassportDetails> passportDetails) {
        this.passportDetails = passportDetails;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                ", passportDetails=" + passportDetails +
                '}';
    }
}