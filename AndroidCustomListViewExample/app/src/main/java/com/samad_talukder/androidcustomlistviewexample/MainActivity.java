package com.samad_talukder.androidcustomlistviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<AndroidVersion> androidVersionList;
    private ListView customListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customListView = findViewById(R.id.customListView);
        customListView.setAdapter(new CustomListViewAdapter(this,R.layout.item_custom_listview,getAndroidVersionList()));

    }

    private List<AndroidVersion> getAndroidVersionList() {
        List<AndroidVersion> androidVersionList = new ArrayList<>();
        androidVersionList.add(new AndroidVersion(R.drawable.cupcake,"Android Cupcake","1.5"));
        androidVersionList.add(new AndroidVersion(R.drawable.donut,"Android Donut","1.6"));
        androidVersionList.add(new AndroidVersion(R.drawable.eclair,"Android Eclair","2.0"));
        androidVersionList.add(new AndroidVersion(R.drawable.froyo,"Android Froyo","2.2"));
        androidVersionList.add(new AndroidVersion(R.drawable.gingerbread,"Android Gingerbread","2.3"));
        androidVersionList.add(new AndroidVersion(R.drawable.honeycomb,"Android Honeycomb","3.0"));
        androidVersionList.add(new AndroidVersion(R.drawable.ice_cream_sandwich,"Android Ice Cream Sandwich","4.0"));
        androidVersionList.add(new AndroidVersion(R.drawable.jelly_bean,"Android Jelly Bean","4.1"));
        androidVersionList.add(new AndroidVersion(R.drawable.kitkat,"Android KitKat","4.4"));
        androidVersionList.add(new AndroidVersion(R.drawable.lollipop,"Android Lollipop","5.0"));
        androidVersionList.add(new AndroidVersion(R.drawable.marshmallow,"Android Marshmallow","6.0"));
        androidVersionList.add(new AndroidVersion(R.drawable.nougat,"Android Nougat","7.0"));
        androidVersionList.add(new AndroidVersion(R.drawable.oreo,"Android Oreo","8.0"));
        androidVersionList.add(new AndroidVersion(R.mipmap.ic_launcher,"Android Pie","9.0"));

        return androidVersionList;
    }
}
