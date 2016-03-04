package com.smusgrave.app.tvpa.ui.showdetails;

import com.smusgrave.app.tvpa.di.scope.PerFeature;
import com.smusgrave.app.tvpa.service.TvMazeService;

import dagger.Module;
import dagger.Provides;

@Module
public class ShowDetailsModule {

    @Provides
    @PerFeature
    public ShowDetailsActivityPresenter provideShowDetailsActivityPresenter(TvMazeService tvMazeService) {
        return new ShowDetailsActivityPresenter(tvMazeService);
    }

}
