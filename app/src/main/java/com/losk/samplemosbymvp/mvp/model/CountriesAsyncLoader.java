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

    public CountriesAsyncLoader(CountriesLoaderListener listener) {
        this.listener = listener;
    }

    @Override
    protected List<Country> doInBackground(Void... voids) {

        //simulation of downloading data
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
            listener.onError(new Exception("Oops, something went wrong!"));
        } else {
            listener.onSuccess(countries);
        }
    }
}