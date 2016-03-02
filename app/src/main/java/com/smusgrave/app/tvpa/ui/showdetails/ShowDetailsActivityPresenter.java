package com.smusgrave.app.tvpa.ui.showdetails;

import com.smusgrave.app.tvpa.common.BasePresenter;

import rx.Subscription;

public class ShowDetailsActivityPresenter extends BasePresenter<ShowDetailsActivityPresenter.View> {

    private Subscription subscription;

    void updateUI(int showId) {

    }

    public interface View extends BasePresenter.View {

        void setTitle(String title);

        void setSummary(String summary);

    }

}
