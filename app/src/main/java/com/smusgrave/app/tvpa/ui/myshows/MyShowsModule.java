package com.smusgrave.app.tvpa.ui.myshows;

import com.smusgrave.app.tvpa.di.scope.PerFeature;
import com.smusgrave.app.tvpa.service.TvMazeService;

import dagger.Module;
import dagger.Provides;

@Module
public class MyShowsModule {

    @Provides
    @PerFeature
    public MyShowsActivityPresenter provideMainActivityPresenter(TvMazeService tvMazeService) {
        return new MyShowsActivityPresenter(tvMazeService);
    }

}
