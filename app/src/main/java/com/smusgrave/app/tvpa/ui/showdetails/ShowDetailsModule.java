package com.smusgrave.app.tvpa.ui.showdetails;

import com.smusgrave.app.tvpa.di.scope.PerFeature;

import dagger.Module;
import dagger.Provides;

@Module
public class ShowDetailsModule {

    @Provides
    @PerFeature
    public ShowDetailsActivityPresenter provideShowDetailsActivityPresenter() {
        return new ShowDetailsActivityPresenter();
    }

}
