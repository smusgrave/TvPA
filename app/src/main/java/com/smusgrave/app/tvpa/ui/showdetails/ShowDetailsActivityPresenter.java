package com.smusgrave.app.tvpa.ui.showdetails;

import com.smusgrave.app.tvpa.common.BasePresenter;
import com.smusgrave.app.tvpa.model.Show;
import com.smusgrave.app.tvpa.service.TvMazeService;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class ShowDetailsActivityPresenter extends BasePresenter<ShowDetailsActivityPresenter.View> {

    private TvMazeService tvMazeService;
    private Subscription subscription;

    @Inject
    public ShowDetailsActivityPresenter(TvMazeService tvMazeService) {
        this.tvMazeService = tvMazeService;
    }

    void init(int showId) {

        getView().showProgress("Loading...");
        subscription = tvMazeService.getShow(showId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        show -> {
                            getView().updateUI(show);
                            getView().hideProgress();
                        },
                        throwable -> {
                            Timber.d(throwable.toString());
                            getView().showMessage(throwable.getMessage(), true);
                            getView().hideProgress();
                        }
                );

    }

    void addToMyShows(int showId) {

        getView().showMessage("TODO: Add to My Shows " + showId, false);

    }

    @Override
    public void onDestroy() {

        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        super.onDestroy();

    }

    public interface View extends BasePresenter.View {

        void updateUI(Show show);

    }

}
