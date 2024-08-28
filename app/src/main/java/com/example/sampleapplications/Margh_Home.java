package com.example.sampleapplications;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

public class Margh_Home extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_margh_home);
        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost); // initiate TabHost
        TabHost.TabSpec spec; // Reusable TabSpec for each tab
        Intent intent; // Reusable Intent for each tab


        // Do the same for the other tabs

        spec = tabHost.newTabSpec("Home"); // Create a new TabSpec using tab host
        spec.setIndicator("", getResources().getDrawable(R.drawable.ic_home_foreground));
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, ImageScroll.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Profile"); // Create a new TabSpec using tab host
        spec.setIndicator("", getResources().getDrawable(R.drawable.profile));
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, Margh_Profile.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

       /* spec = tabHost.newTabSpec("About"); // Create a new TabSpec using tab host
        spec.setIndicator("ABOUT"); // set the “ABOUT” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, NotificationExample.class);
        spec.setContent(intent);
        tabHost.addTab(spec);*/
        //set tab which one you want to open first time 0 or 1 or 2
        tabHost.setCurrentTab(0);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                // display the name of the tab whenever a tab is changed
                Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
            }
        });

    }
}