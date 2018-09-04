package com.skill_centric.objectbox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.Query;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private BoxStore boxStore;
    private Box<Student> studentBox;
    private Box<Address> addressBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boxStore = ((TheApp) getApplication()).getBoxStore();
        studentBox = boxStore.boxFor(Student.class);
        addressBox = boxStore.boxFor(Address.class);

        studentBox.removeAll();
        storeStudents();
        Toast.makeText(this, "Students are created!", Toast.LENGTH_SHORT).show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                findByName();

                findByNameGenderBirth();
            }
        });
    }

    private void findByName() {

        Query<Student> query = studentBox.query().equal(Student_.lastName, "Jackson").build();
        List<Student> students = query.find();
        printStudents(students);
    }

    private void findByNameGenderBirth() {

        Query<Student> query = studentBox.query().equal(Student_.lastName, "Jackson")
                .equal(Student_.gender, "female")
                .greater(Student_.dateOfBirth, new GregorianCalendar(1999, 1, 1).getTime())
                .build();
        List<Student> students = query.find();
        printStudents(students);
    }

    // NOTE: in production code persistence related operations
    // must be done in the background thread!
    private void storeStudents() {

        // Create student1
        Student student1 = new Student(0, "James", "Jackson", 87.5,
                Gender.MALE, new GregorianCalendar(1999, 5, 6).getTime());

        Address address11 = new Address(0, "Russia", "Moscow", "Lenin St.",
                123, "623500");

        Address address12 = new Address(0, "Russia", "St. Petersburg", "Broad St.",
                543, "432890");

        student1.getAddresses().add(address11);
        student1.getAddresses().add(address12);

        // Create student2
        Student student2 = new Student(0, "Jane", "Jackson", 95.4,
                Gender.FEMALE, new GregorianCalendar(2000, 1, 4).getTime());

        Address address21 = new Address(0, "UK", "London", "Abchurch Lane",
                12, "AD232B");

        Address address22 = new Address(0, "UK", "London", "Idol Lane",
                43, "UI3232L");

        student2.getAddresses().add(address21);
        student2.getAddresses().add(address22);

        // Create student3
        Student student3 = new Student(0, "Mike", "Nickson", 82.3,
                Gender.MALE, new GregorianCalendar(1998, 3, 8).getTime());

        Address address31 = new Address(0, "USA", "New York", "Sheffield Ave.",
                77, "14075");

        Address address32 = new Address(0, "USA", "New York", "Baker Ave",
                605, "11758");

        student3.getAddresses().add(address31);
        student3.getAddresses().add(address32);

        // Store the addresses and the students
        addressBox.put(Arrays.asList(address11, address12, address21, address22, address31, address32));
        studentBox.put(Arrays.asList(student1, student2, student3));
    }

    private void printStudents(List<Student> students) {
        for (Student student : students) {
            Log.d(TAG, "-----------------------------------");
            Log.d(TAG, student.toString());
            Log.d(TAG, "-----------------------------------");
        }
    }
}
