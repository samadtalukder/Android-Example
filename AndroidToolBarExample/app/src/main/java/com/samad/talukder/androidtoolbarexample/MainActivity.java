package com.samad.talukder.androidtoolbarexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        // show title in toolbar
        toolbar.setTitle(getString(R.string.app_name));
        // show subtitle in toolbar
        toolbar.setSubtitle(getString(R.string.app_name));
        // show navigation icon in toolbar
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.nav_menu));
        // show title text color in toolbar
        // toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        // show subtitle text color in toolbar
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));

        setSupportActionBar(toolbar);
        // hide toolbar text
        // getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
