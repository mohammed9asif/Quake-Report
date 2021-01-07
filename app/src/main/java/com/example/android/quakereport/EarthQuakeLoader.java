package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class EarthQuakeLoader extends AsyncTaskLoader<List<EarthQuake>> {


    String url;
    public EarthQuakeLoader(Context context,String url) {

        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {

        Log.i("hello","On start loader called");
        forceLoad();
    }

    @Override
    public List<EarthQuake> loadInBackground() {

        Log.i("LOG_TAG","Load in backgroung method called");
        if(url==null)
            return null;
        return QueryUtils.fetchEarthquakeData(url);
    }






}
