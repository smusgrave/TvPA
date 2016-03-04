package com.smusgrave.app.tvpa.ui.showdetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.smusgrave.app.tvpa.R;
import com.smusgrave.app.tvpa.common.BaseActivity;
import com.smusgrave.app.tvpa.common.BasePresenter;
import com.smusgrave.app.tvpa.di.AppComponent;
import com.smusgrave.app.tvpa.model.Show;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class ShowDetailsActivity extends BaseActivity implements ShowDetailsActivityPresenter.View {

    @Inject ShowDetailsActivityPresenter presenter;

    public static final String EXTRA_SHOW_DETAILS_ID = "com.smusgrave.app.tvpa.EXTRA_SHOW_DETAILS_ID";

    private int showId;

    @Bind(R.id.backdrop) ImageView backdrop;
    @Bind(R.id.details_show_title) TextView showTitle;
    @Bind(R.id.details_show_summary) TextView showSummary;
    @Bind(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbarLayout;

    public static Intent getIntent(Context context, int id) {
        Intent intent = new Intent(context, ShowDetailsActivity.class);
        intent.putExtra(EXTRA_SHOW_DETAILS_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeToolbar(true, R.string.title_show_details);

        showId = getIntent().getIntExtra(EXTRA_SHOW_DETAILS_ID, 0);
        presenter.init(showId);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_show_details;
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void initializePresenter() {
        presenter.setView(this);
    }

    @Override
    public void setupComponent(AppComponent component) {
        DaggerShowDetailsComponent.builder()
                .appComponent(component)
                .showDetailsModule(new ShowDetailsModule())
                .build()
                .inject(this);
    }

    @Override
    public void updateUI(Show show) {

        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(show.name);
        }

        showTitle.setText(show.name);
        showSummary.setText(Html.fromHtml(show.summary));

        Picasso.with(this).load(show.image.medium).into(backdrop);

    }

    @OnClick(R.id.fab)
    void fabClicked() {
        presenter.addToMyShows(showId);
    }
}
