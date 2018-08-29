package com.skill_centric.objectbox;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class MainActivity extends AppCompatActivity {

    private BoxStore boxStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boxStore = ((TheApp) getApplication()).getBoxStore();
        final Box<Student> studentBox = boxStore.boxFor(Student.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Student studentOne = new Student();
                studentOne.setFullName("Jane Austin");
                studentOne.setGrade(Math.random());

                long id = studentBox.put(studentOne);
                Student loadedStudent = studentBox.get(id);

                Snackbar.make(view, "Stored student " + loadedStudent, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
