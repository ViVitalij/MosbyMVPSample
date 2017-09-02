package com.losk.samplemosbymvp.mvp.lce.viewpager.viewstate;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;

import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.MvpLceViewStateFragment;
import com.losk.samplemosbymvp.mvp.CountriesPresenter;
import com.losk.samplemosbymvp.mvp.CountriesView;
import com.losk.samplemosbymvp.mvp.model.Country;

import java.util.List;

public class RetainingCountriesFragment
        extends MvpLceViewStateFragment<SwipeRefreshLayout, List<Country>, CountriesView, CountriesPresenter>
        implements CountriesView, SwipeRefreshLayout.OnRefreshListener {


    @Override
    public void onRefresh() {

    }

    @Override
    public List<Country> getData() {
        return null;
    }

    @Override
    public CountriesPresenter createPresenter() {
        return null;
    }

    @NonNull
    @Override
    public LceViewState<List<Country>, CountriesView> createViewState() {
        return null;
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public void setData(List<Country> data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }
}
