package com.smusgrave.app.tvpa.ui.myshows;

import com.smusgrave.app.tvpa.di.AppComponent;
import com.smusgrave.app.tvpa.di.scope.PerFeature;

import dagger.Component;

@PerFeature
@Component(
        dependencies = AppComponent.class,
        modules = MyShowsModule.class
)
public interface MyShowsComponent {

    void inject(MyShowsActivity myShowsActivity);

}
