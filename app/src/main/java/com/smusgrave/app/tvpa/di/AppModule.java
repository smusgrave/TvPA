package com.smusgrave.app.tvpa.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.smusgrave.app.tvpa.App;
import com.smusgrave.app.tvpa.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @PerApp
    public Application provideApplication() {
        return app;
    }

    @Provides
    @PerApp
    public Context provideApplicationContext() {
        return app;
    }

    @Provides
    @PerApp
    public SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

}
