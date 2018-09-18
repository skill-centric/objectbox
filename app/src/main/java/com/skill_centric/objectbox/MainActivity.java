package com.skill_centric.objectbox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.GregorianCalendar;

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

                Major major = new Major("CS");

                PassportDetails passportDetails = new PassportDetails();
                passportDetails.setCode(123);
                passportDetails.setRegistrationAddress("SomeCountry, SomeCity, SomeStreet, 99");
                passportDetails.setDateOfBirth(new GregorianCalendar(1985, 1, 1).getTime());

                Student student = new Student();
                student.setFirstName("Mike");
                student.setLastName("Jackson");
                student.setGrade(95.5);
                student.getPassportDetails().setTarget(passportDetails);

                Student studentTwo = new Student();
                studentTwo.setFirstName("Jane");
                studentTwo.setLastName("Austin");
                studentTwo.setGrade(99.5);

                major.getStudents().add(student);
                major.getStudents().add(studentTwo);

                majorBox.put(major);

                for (Student theStudent : major.getStudents()) {
                    Log.d("MainActivity", "Student: " + theStudent);
                }
            }
        });
    }
}
