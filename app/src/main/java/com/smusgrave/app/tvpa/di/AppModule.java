package com.smusgrave.app.tvpa.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.smusgrave.app.tvpa.App;
import com.smusgrave.app.tvpa.di.scope.PerApp;
import com.smusgrave.app.tvpa.service.TvMazeService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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

    @Provides
    @PerApp
    public TvMazeService provideTvMazeService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TvMazeService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(TvMazeService.class);
    }

}
