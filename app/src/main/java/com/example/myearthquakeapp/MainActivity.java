package com.example.myearthquakeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//            final ArrayList<earthquake> earthquakes = new ArrayList<earthquake>();

//            earthquakes.add(new earthquake("5.8", "SAN FRANCISCO", "July 23, 1987"));
//            earthquakes.add(new earthquake("4.4", " BRAZIL ", "Feb 3, 1980"));
//            earthquakes.add(new earthquake("3.9", "INDIA", "Jan 7,1970"));
//            earthquakes.add(new earthquake("3.8", "CHINA", "June 2,1978"));
//            earthquakes.add(new earthquake("5.7", "UKRAINE", "Dec 8,2005"));
//            earthquakes.add(new earthquake("6.2", "NEW YORK", "August 11,1990"));
//            earthquakes.add(new earthquake("3.6", "WASHINGTON DC", "April 21,2009"));
//            earthquakes.add(new earthquake("4.6", "MOROCCO", "July 17,1999"));
//            earthquakes.add(new earthquake("5.0", "SYDNEY", "November 30,1996"));
//            earthquakes.add(new earthquake("4.9", "CALIFORNIA", "March 1,1993"));

        ArrayList<earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Create a new adapter that takes the list of earthquakes as input
        final earthquakeAdapter objectAdapter = new earthquakeAdapter(this, earthquakes);

        ListView earthquakeListView = (ListView) findViewById(R.id.earthquake_list);
            earthquakeListView.setAdapter(objectAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                earthquake currentEarthquake = objectAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });


    }
}