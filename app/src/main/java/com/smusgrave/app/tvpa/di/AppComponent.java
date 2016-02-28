package com.smusgrave.app.tvpa.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.smusgrave.app.tvpa.di.scope.PerApp;

import dagger.Component;

@PerApp
@Component(modules = AppModule.class)
public interface AppComponent {

    Context getContext();

    SharedPreferences getSharedPreferences();

}
