package com.skill_centric.objectbox;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class Professor {

    @Id
    private long id;
    private String firstName;
    private String lastName;

    @Backlink(to = "professors")
    private ToMany<Student> students;

    public Professor() {
    }

    public Professor(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

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

    public ToMany<Student> getStudents() {
        return students;
    }

    public void setStudents(ToMany<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", students=" + students +
                '}';
    }
}
