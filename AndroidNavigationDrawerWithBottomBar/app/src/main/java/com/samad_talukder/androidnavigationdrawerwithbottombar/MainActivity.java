package com.samad_talukder.androidnavigationdrawerwithbottombar;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.samad_talukder.androidnavigationdrawerwithbottombar.fragment.AboutFragment;
import com.samad_talukder.androidnavigationdrawerwithbottombar.fragment.DiscoverFragment;
import com.samad_talukder.androidnavigationdrawerwithbottombar.fragment.HomeFragment;
import com.samad_talukder.androidnavigationdrawerwithbottombar.fragment.TrendingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.frame_layout_content)
    FrameLayout frameLayoutContent;

    @BindView(R.id.bottom_nav)
    BottomNavigationView bottomNav;

    @BindView(R.id.ivDoctor)
    ImageView ivDoctor;

    @BindView(R.id.rlCir)
    RelativeLayout rlCir;

    @BindView(R.id.tvDocName)
    TextView tvDocName;

    @BindView(R.id.nav_view)
    NavigationView navView;

    @BindView(R.id.nav_view_header)
    NavigationView navViewHeader;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        replaceFragment(HomeFragment.getFragment());

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        bottomNav.setOnNavigationItemSelectedListener(onBottomNavigationItemSelectedListener);

        navView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setItemIconTintList(null);

    }


    BottomNavigationView.OnNavigationItemSelectedListener onBottomNavigationItemSelectedListener = item -> {

        switch (item.getItemId()) {

            case R.id.bottom_item_home:
                replaceFragment(HomeFragment.getFragment());
                return true;

            case R.id.bottom_item_discover:
                replaceFragment(DiscoverFragment.getFragment());
                return true;

            case R.id.bottom_item_trending:
                replaceFragment(TrendingFragment.getFragment());
                return true;

            case R.id.bottom_item_about:
                replaceFragment(AboutFragment.getFragment());
                return true;

        }

        return false;
    };

    NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            new Handler().postDelayed(() -> {

                switch (item.getItemId()) {

                    case R.id.nav_item_home:
                        replaceFragment(HomeFragment.getFragment());
                        bottomNav.setSelectedItemId(R.id.bottom_item_home);
                        break;

                    case R.id.nav_item_discover:
                        replaceFragment(DiscoverFragment.getFragment());
                        bottomNav.setSelectedItemId(R.id.bottom_item_discover);
                        break;

                    case R.id.nav_item_trending:
                        replaceFragment(TrendingFragment.getFragment());
                        bottomNav.setSelectedItemId(R.id.bottom_item_trending);
                        break;

                    case R.id.nav_item_about:
                        replaceFragment(AboutFragment.getFragment());
                        bottomNav.setSelectedItemId(R.id.bottom_item_about);
                        break;
                }

            }, 50);

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
    };

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout_content, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (bottomNav.getSelectedItemId() == R.id.bottom_item_home) {
            super.onBackPressed();
        } else {
            bottomNav.setSelectedItemId(R.id.bottom_item_home);
        }
    }
}
