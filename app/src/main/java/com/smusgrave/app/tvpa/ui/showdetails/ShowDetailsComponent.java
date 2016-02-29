package com.smusgrave.app.tvpa.ui.showdetails;

import com.smusgrave.app.tvpa.di.AppComponent;
import com.smusgrave.app.tvpa.di.scope.PerFeature;

import dagger.Component;

@PerFeature
@Component(
        dependencies = AppComponent.class,
        modules = ShowDetailsModule.class
)
public interface ShowDetailsComponent {

    void inject(ShowDetailsActivity showDetailsActivity);

}
