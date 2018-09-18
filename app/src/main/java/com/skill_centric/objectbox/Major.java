package com.skill_centric.objectbox;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

@Entity
public class Major {

    @Id
    private long id;
    private String title;

    @Backlink(to = "major")
    private ToMany<Student> students;

    public Major() {
    }

    public Major(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ToMany<Student> getStudents() {
        return students;
    }

    public void setStudents(ToMany<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", students=" + students +
                '}';
    }
}
