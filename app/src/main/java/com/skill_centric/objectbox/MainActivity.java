package com.skill_centric.objectbox;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.GregorianCalendar;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BoxStore is an interface to access ObjectBox
        BoxStore boxStore = ((TheApp) getApplication()).getBoxStore();

        final Box<User> userBox = boxStore.boxFor(User.class);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User(0, "James", "Jackson",
                        new GregorianCalendar(1987, 10, 12).getTime());

                userBox.put(user);
            }
        });
    }
}
