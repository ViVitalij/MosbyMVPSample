package com.losk.samplemosbymvp.mvp.lce;

import android.util.Log;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.losk.samplemosbymvp.mvp.CountriesPresenter;
import com.losk.samplemosbymvp.mvp.CountriesView;
import com.losk.samplemosbymvp.mvp.model.CountriesAsyncLoader;
import com.losk.samplemosbymvp.mvp.model.Country;

import java.util.List;

//TODO check
public class SimpleCountriesPresenter extends MvpBasePresenter<CountriesView>
        implements CountriesPresenter {

    private static final String TAG = "CountriesPresenter";

    private CountriesAsyncLoader countriesLoader;

    public SimpleCountriesPresenter() {
        Log.d(TAG, "constructor " + toString());
    }

    @Override
    public void loadCountries(final boolean pullToRefresh) {

        Log.d(TAG, "loadCountries(" + pullToRefresh + ")");

        Log.d(TAG, "showLoading(" + pullToRefresh + ")");

        getView().showLoading(pullToRefresh);

        if (countriesLoader != null && !countriesLoader.isCancelled()) {
            countriesLoader.cancel(true);
        }

        countriesLoader = new CountriesAsyncLoader(new CountriesAsyncLoader.CountriesLoaderListener() {

                    @Override
                    public void onSuccess(List<Country> countries) {

                        if (isViewAttached()) {
                            Log.d(TAG, "setData()");
                            getView().setData(countries);

                            Log.d(TAG, "showContent()");
                            getView().showContent();
                        }
                    }

                    @Override
                    public void onError(Exception e) {

                        if (isViewAttached()) {

                            Log.d(TAG, "showError(" + e.getClass().getSimpleName() + " , "
                                    + pullToRefresh + ")");
                            getView().showError(e, pullToRefresh);
                        }
                    }
                });
        countriesLoader.execute();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);

        StringBuilder builder = new StringBuilder("---- detachView(" + retainInstance + ") ");
        if (!retainInstance) {
            if (countriesLoader != null) {
                countriesLoader.cancel(true);
            }
            builder.append(" --> cancel Loader");
        }

        builder.append(" ----");
        Log.d(TAG, builder.toString());
    }

    @Override
    public void attachView(CountriesView view) {
        super.attachView(view);
        Log.d(TAG, "attach view " + view.toString());
    }
}