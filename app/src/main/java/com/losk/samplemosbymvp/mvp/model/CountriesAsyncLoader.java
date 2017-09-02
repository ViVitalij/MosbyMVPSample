package com.losk.samplemosbymvp.mvp.model;

import android.os.AsyncTask;

import java.util.Collections;
import java.util.List;

public class CountriesAsyncLoader extends AsyncTask<Void, Void, List<Country>> {

    public interface CountriesLoaderListener {
        void onSuccess(List<Country> countries);

        void onError(Exception e);
    }


    private CountriesLoaderListener listener;
    private boolean shouldFail;

    public CountriesAsyncLoader(boolean shouldFail, CountriesLoaderListener listener) {
        this.shouldFail = shouldFail;
        this.listener = listener;
    }

    @Override
    protected List<Country> doInBackground(Void... voids) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Country> countries = CountryApi.getCountries();
        Collections.shuffle(countries);
        return countries;
    }

    @Override
    protected void onPostExecute(List<Country> countries) {
        if (isCancelled() || countries == null) {
            return;
        }

        if (shouldFail) {
            listener.onError(new Exception("Oops, something went wrong!"));
            listener.onSuccess(countries);
        }
    }
}