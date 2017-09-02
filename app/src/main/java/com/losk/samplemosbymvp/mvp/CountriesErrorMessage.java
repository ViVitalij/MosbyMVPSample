package com.losk.samplemosbymvp.mvp;

import android.content.Context;

import com.losk.samplemosbymvp.R;


public class CountriesErrorMessage {
    public static String get(Throwable e, boolean pullToRefresh, Context context) {
        if (pullToRefresh) {
            return context.getString(R.string.error_loading_countries);
        } else {
            return context.getString(R.string.error_loading_countries_retry);
        }
    }
}