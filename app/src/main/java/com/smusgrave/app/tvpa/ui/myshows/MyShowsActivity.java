package com.smusgrave.app.tvpa.ui.myshows;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.smusgrave.app.tvpa.R;
import com.smusgrave.app.tvpa.common.BaseActivity;
import com.smusgrave.app.tvpa.common.BasePresenter;
import com.smusgrave.app.tvpa.di.AppComponent;
import com.smusgrave.app.tvpa.ui.search.SearchActivity;

import javax.inject.Inject;

import butterknife.OnClick;

public class MyShowsActivity extends BaseActivity implements MyShowsActivityPresenter.View {

    @Inject MyShowsActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeToolbar(false, R.string.title_my_shows);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_my_shows;
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
        DaggerMyShowsComponent.builder()
                .appComponent(component)
                .myShowsModule(new MyShowsModule())
                .build()
                .inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void onFabClick() {
        presenter.onFabClicked();
    }

    @Override
    public void navigateToSearch() {
        startActivity(SearchActivity.getIntent(this));
    }
}
