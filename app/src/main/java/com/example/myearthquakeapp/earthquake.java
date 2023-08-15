package com.example.myearthquakeapp;

public class earthquake {

    private double myMagnitude;
    private String myLocation;
    private long myDate;
    private String myurl;


    public earthquake(double myActualMagnitude,String myActualLocation,long myActualDate,String myActualurl){
        myMagnitude=myActualMagnitude;
        myLocation=myActualLocation;
        myDate=myActualDate;
        myurl=myActualurl;


    }
    public double getMagnitude(){
        return  myMagnitude;
    }
    public String getLocation(){
        return  myLocation;
    }
    public long getDate(){
        return  myDate;
    }
    public String getUrl(){return myurl;}
}
