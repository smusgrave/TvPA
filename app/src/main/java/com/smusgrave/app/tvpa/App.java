package com.smusgrave.app.tvpa;

import android.app.Application;
import android.content.Context;

import com.smusgrave.app.tvpa.di.AppComponent;
import com.smusgrave.app.tvpa.di.AppModule;
import com.smusgrave.app.tvpa.di.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

public class App extends Application {

    public static final String PREF_KEY_MY_SHOWS = "my_shows";

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        initLeakDetection();
        initLogger();
    }

    private void initComponent() {
        component = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }

    public static App getApp(Context content) {
        return (App) content.getApplicationContext();
    }

    private void initLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

}
