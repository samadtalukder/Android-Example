package com.samad.talukder.androidviewpagerwithcustompageradapter;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.samad.talukder.androidviewpagerwithcustompageradapter.adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private Handler handler = new Handler();
    private Runnable runnable = null;
    private CustomAdapter customAdapter;
    private LinearLayout dotIndicator;
    private ImageButton bt_previous, bt_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        // start auto slider method
        startAutoSlider(customAdapter.getCount());

    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager);
        dotIndicator = findViewById(R.id.indicator);
        bt_previous = findViewById(R.id.bt_previous);
        bt_next = findViewById(R.id.bt_next);
        // adapter call
        customAdapter = new CustomAdapter(getApplicationContext(), getDataItem());
        viewPager.setAdapter(customAdapter);
        viewPager.setCurrentItem(0);
        // add dot indicator method
        addBottomDots(dotIndicator, customAdapter.getCount(), 0);
        // button click action
        bt_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevAction();
            }
        });
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextAction();
            }
        });
        // viewpager
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                addBottomDots(dotIndicator,customAdapter.getCount(),i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    private void startAutoSlider(final int count) {
        runnable = new Runnable() {
            @Override
            public void run() {
                int pos = viewPager.getCurrentItem();
                pos = pos + 1;
                if (pos >= count) pos = 0;
                viewPager.setCurrentItem(pos);
                handler.postDelayed(runnable, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);
    }

    private void addBottomDots(LinearLayout layout_dots, int size, int current) {
        ImageView[] dots = new ImageView[size];

        layout_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            int width_height = 20;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(10, 10, 10, 10);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.shape_circle);
            dots[i].setColorFilter(ContextCompat.getColor(this, R.color.colorActive));
            layout_dots.addView(dots[i]);
        }

        if (dots.length > 1) {
            dots[current].setColorFilter(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }
    }


    private void nextAction() {
        int pos = viewPager.getCurrentItem();
        pos = pos + 1;
        if (pos >= customAdapter.getCount()) pos = 0;
        viewPager.setCurrentItem(pos);
    }

    private void prevAction() {
        int pos = viewPager.getCurrentItem();
        pos = pos - 1;
        if (pos < 0) pos = customAdapter.getCount();
        viewPager.setCurrentItem(pos);
    }

    private List<DataModel> getDataItem() {
        List<DataModel> dataModelList = new ArrayList<>();
        dataModelList.add(new DataModel(R.drawable.andro, "Image Slider "));
        dataModelList.add(new DataModel(R.drawable.andro, "Dots Indicator"));
        dataModelList.add(new DataModel(R.drawable.andro, "Android Studio"));
        dataModelList.add(new DataModel(R.drawable.andro, "Text 2"));
        return dataModelList;
    }

}
