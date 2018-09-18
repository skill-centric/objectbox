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
    private Box<Professor> professorBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boxStore = ((TheApp) getApplication()).getBoxStore();
        studentBox = boxStore.boxFor(Student.class);
        majorBox = boxStore.boxFor(Major.class);
        professorBox = boxStore.boxFor(Professor.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Professor professorOne = new Professor(0L, "Mike", "Jackson");
                Professor professorTwo = new Professor(0L, "James", "Johnson");

                Student studentOne = new Student(0L, "Jane", "Austin", 99.5);
                studentOne.getProfessors().add(professorOne);
                studentOne.getProfessors().add(professorTwo);

                Student studentTwo = new Student(0L, "Tom", "Nickson", 89.4);
                studentTwo.getProfessors().add(professorTwo);

                studentBox.put(studentOne);
                studentBox.put(studentTwo);

                Professor theProfessor = professorBox.get(2L);

                for (Student student : theProfessor.getStudents()) {
                    Log.d("MainActivity", "Student: " + student);
                }
            }
        });
    }
}
