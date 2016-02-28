package com.smusgrave.app.tvpa.ui.search;

import com.smusgrave.app.tvpa.di.AppComponent;
import com.smusgrave.app.tvpa.di.scope.PerFeature;

import dagger.Component;

@PerFeature
@Component(
        dependencies = AppComponent.class,
        modules = SearchModule.class
)
public interface SearchComponent {

    void inject(SearchActivity searchActivity);

}
