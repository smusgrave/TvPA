package com.smusgrave.app.tvpa.ui.showdetails;

import com.smusgrave.app.tvpa.common.BasePresenter;

public class ShowDetailsActivityPresenter extends BasePresenter<ShowDetailsActivityPresenter.View> {

    void updateUI() {

    }

    public interface View extends BasePresenter.View {

        void setTitle(String title);

        void setSummary(String summary);

    }

}
