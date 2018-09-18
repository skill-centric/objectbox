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
    private Box<Student> studentBox;
    private Box<Person> personBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boxStore = ((TheApp) getApplication()).getBoxStore();
        studentBox = boxStore.boxFor(Student.class);
        personBox = boxStore.boxFor(Person.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Person person = new Person(0l, "Mike", "Johnes");
                personBox.put(person);
                Person thePerson = personBox.get(1L);
                Log.d("MainActivity", "Person: " + thePerson);

                Student student = new Student(0L, "Jane", "Austin", 88.5);
                studentBox.put(student);
                Student theStudent = studentBox.get(1L);
                Log.d("MainActivity", "Student: " + theStudent);
            }
        });
    }
}
