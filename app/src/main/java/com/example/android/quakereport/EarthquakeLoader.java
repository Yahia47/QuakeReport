package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;


import java.util.List;


public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    public static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<Earthquake> result = QueryUtils.fetchEarthquakeData(mUrl);

        return result;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
