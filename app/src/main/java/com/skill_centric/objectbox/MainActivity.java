package com.skill_centric.objectbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.Query;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BoxStore is an interface to access ObjectBox
        BoxStore boxStore = ((TheApp) getApplication()).getBoxStore();

        // Get a "box" for your entities
        final Box<Student> studentBox = boxStore.boxFor(Student.class);

        // Do some Create Read Update Delete (CRUD) operations

        // Create
        Student studentOne = new Student();
        studentOne.setFullName("Jane Austin");
        studentOne.setGrade(90.5);
        studentBox.put(studentOne);

        Student studentTwo = new Student();
        studentTwo.setFullName("Mark Twain");
        studentTwo.setGrade(95.5);
        studentBox.put(studentTwo);

        // Read
        Query<Student> query = studentBox.query().order(Student_.grade).build();
        List<Student> students = query.find();

        // Update
        studentOne.setGrade(93.5);
        studentBox.put(studentOne);

        // Delete
        studentBox.remove(studentOne);
    }
}
