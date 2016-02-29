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
    public static final String TEMP_EXTRA_TITLE = "show_title";
    public static final String TEMP_EXTRA_SUMMARY = "show_summary";

    @Bind(R.id.details_show_summary) TextView summary;

    public static Intent getIntent(Context context, int id, String title, String summary) {
        Intent intent = new Intent(context, ShowDetailsActivity.class);
        intent.putExtra(EXTRA_SHOW_DETAILS_ID, id);
        intent.putExtra(TEMP_EXTRA_TITLE, title);
        intent.putExtra(TEMP_EXTRA_SUMMARY, summary);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeToolbar(true, R.string.title_show_details);

        // TODO These extras passed in for testing, eventually only id should be passed as extra
        setTitle(getIntent().getStringExtra(TEMP_EXTRA_TITLE));
        setSummary(getIntent().getStringExtra(TEMP_EXTRA_SUMMARY));
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
