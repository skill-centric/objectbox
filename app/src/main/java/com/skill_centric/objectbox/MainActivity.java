package com.skill_centric.objectbox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class MainActivity extends AppCompatActivity {

    private BoxStore boxStore;
    private Box<Major> majorBox;
    private Box<Student> studentBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boxStore = ((TheApp) getApplication()).getBoxStore();
        studentBox = boxStore.boxFor(Student.class);
        majorBox = boxStore.boxFor(Major.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Professor professorOne = new Professor(0L, "Mike", "Jackson");
                Professor professorTwo = new Professor(0L, "James", "Johnson");

                Student student = new Student();
                student.setFirstName("Jane");
                student.setLastName("Austin");
                student.setGrade(99.5);

                student.getProfessors().add(professorOne);
                student.getProfessors().add(professorTwo);

                studentBox.put(student);

                for (Professor professor : student.getProfessors()) {

                    Log.d("MainActivity", "Professor: " + professor);
                }
            }
        });
    }
}
