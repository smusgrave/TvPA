package com.smusgrave.app.tvpa.ui.search;

import com.smusgrave.app.tvpa.common.BasePresenter;
import com.smusgrave.app.tvpa.model.Show;
import com.smusgrave.app.tvpa.service.TvMazeService;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class SearchActivityPresenter extends BasePresenter<SearchActivityPresenter.View> {

    private TvMazeService tvMazeService;
    private Subscription subscription;

    @Inject
    public SearchActivityPresenter(TvMazeService tvMazeService) {
        this.tvMazeService = tvMazeService;
    }

    void performSearch(String text) {

        getView().clearShows();
        getView().showProgress("Searching...");
        subscription = tvMazeService.getShows(text)
                .concatMap(Observable::from)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        showQuery -> {
                            getView().addShow(showQuery.getShow());
                            getView().hideProgress();
                        },
                        throwable -> {
                            Timber.e(throwable.toString());
                            getView().showMessage(throwable.getMessage(), true);
                            getView().hideProgress();
                        }
                );
    }

    @Override
    public void onDestroy() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        super.onDestroy();
    }

    public interface View extends BasePresenter.View {

        void addShow(Show show);

        void clearShows();

    }
}
