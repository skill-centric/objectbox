package com.skill_centric.objectbox;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.GregorianCalendar;

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

        studentBox.removeAll();

        storeStudents();

        Toast.makeText(this, "Students are created!", Toast.LENGTH_SHORT).show();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    private void storeStudents() {

        Student student1 = new Student(0, "James", "Jackson", 87.5,
                Gender.MALE, new GregorianCalendar(1999, 5, 6).getTime());



    }
}
