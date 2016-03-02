package com.smusgrave.app.tvpa.ui.showdetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.smusgrave.app.tvpa.R;
import com.smusgrave.app.tvpa.common.BaseActivity;
import com.smusgrave.app.tvpa.common.BasePresenter;
import com.smusgrave.app.tvpa.di.AppComponent;

import javax.inject.Inject;

import butterknife.Bind;

public class ShowDetailsActivity extends BaseActivity implements ShowDetailsActivityPresenter.View {

    @Inject ShowDetailsActivityPresenter presenter;

    public static final String EXTRA_SHOW_DETAILS_ID = "com.smusgrave.app.tvpa.EXTRA_SHOW_DETAILS_ID";

    @Bind(R.id.details_show_summary) TextView summary;

    public static Intent getIntent(Context context, int id) {
        Intent intent = new Intent(context, ShowDetailsActivity.class);
        intent.putExtra(EXTRA_SHOW_DETAILS_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeToolbar(true, R.string.title_show_details);

        int showId = getIntent().getIntExtra(EXTRA_SHOW_DETAILS_ID, 0);
        presenter.updateUI(showId);
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
    public void setTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void setSummary(String summary) {
        this.summary.setText(Html.fromHtml(summary));
    }
}
