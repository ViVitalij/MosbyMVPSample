package com.losk.samplemosbymvp.mvp;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

public interface CountriesPresenter extends MvpPresenter<CountriesView> {
    void loadCountries(final boolean pullToRefresh);
}
