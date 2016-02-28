package com.smusgrave.app.tvpa.ui.search;

import com.smusgrave.app.tvpa.common.BasePresenter;
import com.smusgrave.app.tvpa.model.Show;
import com.smusgrave.app.tvpa.service.TvMazeService;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class SearchActivityPresenter extends BasePresenter<SearchActivityPresenter.View> {

    private TvMazeService tvMazeService;

    @Inject
    public SearchActivityPresenter(TvMazeService tvMazeService) {
        this.tvMazeService = tvMazeService;
    }

    void performSearch(String text) {

        getView().clearShows();
        tvMazeService.getShows(text)
                .flatMap(Observable::from)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        showQuery -> {
                            getView().addShow(showQuery.show);
                            Timber.d("Show : " + showQuery.show.name);
                        },
                        throwable -> {
                            getView().showMessage("Error: " + throwable.toString(), false);
                            Timber.e(throwable.getMessage());
                        },
                        () -> Timber.d("Complete!")
                );
    }

    public interface View extends BasePresenter.View {

        void addShow(Show show);

        void clearShows();

    }
}