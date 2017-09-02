package com.losk.samplemosbymvp.mvp.lce.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hannesdorfmann.mosby3.mvp.lce.MvpLceActivity;
import com.losk.samplemosbymvp.R;
import com.losk.samplemosbymvp.mvp.CountriesAdapter;
import com.losk.samplemosbymvp.mvp.CountriesErrorMessage;
import com.losk.samplemosbymvp.mvp.CountriesPresenter;
import com.losk.samplemosbymvp.mvp.CountriesView;
import com.losk.samplemosbymvp.mvp.lce.SimpleCountriesPresenter;
import com.losk.samplemosbymvp.mvp.model.Country;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountriesActivity
        extends MvpLceActivity<SwipeRefreshLayout, List<Country>, CountriesView, CountriesPresenter>
        implements CountriesView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private CountriesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countries_list);
        ButterKnife.bind(this);

        // Setup contentView == SwipeRefreshView
        contentView.setOnRefreshListener(this);

        adapter = new CountriesAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        loadData(false);

    }

    @Override
    public void onRefresh() {
        loadData(true);
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return CountriesErrorMessage.get(e, pullToRefresh, this);
    }

    @NonNull
    @Override
    public CountriesPresenter createPresenter() {
        return new SimpleCountriesPresenter();
    }

    @Override
    public void setData(List<Country> countriesList) {
        adapter.setCountries(countriesList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadCountries(pullToRefresh);
    }

    @Override
    public void showContent() {
        super.showContent();
        contentView.setRefreshing(false);
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
        contentView.setRefreshing(false);
    }
}
