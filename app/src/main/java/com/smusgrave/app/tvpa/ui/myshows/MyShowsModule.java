package com.smusgrave.app.tvpa.ui.myshows;

import com.smusgrave.app.tvpa.di.scope.PerFeature;
import com.smusgrave.app.tvpa.service.TvMazeService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MyShowsModule {

    @Provides
    @PerFeature
    public TvMazeService provideTvMazeService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TvMazeService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(TvMazeService.class);
    }

    @Provides
    @PerFeature
    public MyShowsActivityPresenter provideMainActivityPresenter(TvMazeService tvMazeService) {
        return new MyShowsActivityPresenter(tvMazeService);
    }

}
