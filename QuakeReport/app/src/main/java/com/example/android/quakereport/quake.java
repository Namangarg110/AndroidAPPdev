package com.example.android.quakereport;

public class quake
{
    //private variables
    private double mMag ;
    private String mPlace;
    private long mTime;
    private String mURL;

    //Constructor
    public quake(double Mag, String Place, long Time,String url)
    {
        mMag=Mag;
        mPlace=Place;
        mTime=Time;
        mURL = url;
    }

    //getters
    public double getMag()
    {
        return mMag;
    }

    public String getPlace()
    {
        return mPlace;
    }

    public long getTime()
    {
        return mTime;
    }

    public String getURL()
    {
        return mURL;
    }
}
