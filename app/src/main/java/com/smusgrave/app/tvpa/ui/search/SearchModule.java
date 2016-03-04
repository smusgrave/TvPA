package com.smusgrave.app.tvpa.ui.search;

import com.smusgrave.app.tvpa.di.scope.PerFeature;
import com.smusgrave.app.tvpa.service.TvMazeService;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchModule {

    @Provides
    @PerFeature
    public SearchActivityPresenter provideSearchActivityPresenter(TvMazeService tvMazeService) {
        return new SearchActivityPresenter(tvMazeService);
    }

}
