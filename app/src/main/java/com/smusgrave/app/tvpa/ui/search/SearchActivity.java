package com.smusgrave.app.tvpa.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.smusgrave.app.tvpa.R;
import com.smusgrave.app.tvpa.common.BaseActivity;
import com.smusgrave.app.tvpa.common.BasePresenter;
import com.smusgrave.app.tvpa.di.AppComponent;
import com.smusgrave.app.tvpa.model.Show;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnEditorAction;

public class SearchActivity extends BaseActivity implements SearchActivityPresenter.View {

    @Inject SearchActivityPresenter presenter;

    @Bind(R.id.et_search) EditText searchET;
    @Bind(R.id.search_recycler) RecyclerView recycler;

    private SearchAdapter adapter;

    public static Intent getIntent(Context context) {
        return new Intent(context, SearchActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new SearchAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recycler.getContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
    }

    @Override
    protected int getLayout() {
        return R.layout.search_activity;
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
        DaggerSearchComponent.builder()
                .appComponent(component)
                .searchModule(new SearchModule())
                .build()
                .inject(this);
    }

    @OnEditorAction(R.id.et_search)
    public boolean searchAction(int actionId) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            presenter.performSearch(searchET.getText().toString());
            return true;
        }
        return false;
    }

    @Override
    public void addShow(Show show) {
        adapter.add(show);
    }

    @Override
    public void clearShows() {
        adapter.clear();
    }
}
