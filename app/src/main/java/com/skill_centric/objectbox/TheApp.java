package com.skill_centric.objectbox;

import android.app.Application;

import io.objectbox.BoxStore;
import io.objectbox.BoxStoreBuilder;
import io.objectbox.android.AndroidObjectBrowser;

public class TheApp extends Application {

    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();

        initObjectBox();
    }

    private void initObjectBox() {

        BoxStoreBuilder boxStoreBuilder = MyObjectBox.builder().androidContext(TheApp.this);
        boxStore = boxStoreBuilder.build();

        if (BuildConfig.DEBUG) {

            new AndroidObjectBrowser(boxStore).start(this);
        }
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}