package com.smusgrave.app.tvpa.ui.myshows;

import com.smusgrave.app.tvpa.common.BasePresenter;
import com.smusgrave.app.tvpa.service.TvMazeService;

import javax.inject.Inject;

public class MyShowsActivityPresenter extends BasePresenter<MyShowsActivityPresenter.View> {

    private TvMazeService tvMazeService;

    @Inject
    public MyShowsActivityPresenter(TvMazeService tvMazeService) {
        this.tvMazeService = tvMazeService;
    }

    public void onFabClicked() {
        getView().navigateToSearch();
    }

    public interface View extends BasePresenter.View {

        void navigateToSearch();

    }

}
