package com.samad.talukder.androidcheckedtextviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView checkedItemListView;
    private String[] names={"The Daily Star","The New York Times","Daily Prothom-alo","Bangla News 24","Daily Sun"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkedItemListView = findViewById(R.id.checkedItemListView);
        checkedItemListView.setAdapter(new CheckedTextViewAdapter(names,getApplicationContext()));
    }
}
