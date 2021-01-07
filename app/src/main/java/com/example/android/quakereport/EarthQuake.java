
package com.example.android.quakereport;
public class EarthQuake {
    private double magnitude;
    private String cityName;
    private long date;
    private String url;

    public EarthQuake(double magnitude, String cityName, long date,String url) {
        this.magnitude = magnitude;
        this.cityName = cityName;
        this.date = date;
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }



    public String getCityName() {
        return cityName;
    }



    public long getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }


}
