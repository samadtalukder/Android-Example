package com.samad.talukder.androidtablayoutwithviewpagerexample;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabPagerAdapter tabPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.tabViewPager);
        tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(tabPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }
}
