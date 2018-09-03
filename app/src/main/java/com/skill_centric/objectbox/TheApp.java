package com.skill_centric.objectbox;

import android.app.Application;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

public class TheApp extends Application {

    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeObjectBox();
    }

    private void initializeObjectBox() {

        boxStore = MyObjectBox.builder().androidContext(TheApp.this).build();

        if (BuildConfig.DEBUG) {
            boolean started = new AndroidObjectBrowser(boxStore).start(this);
        }

    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}