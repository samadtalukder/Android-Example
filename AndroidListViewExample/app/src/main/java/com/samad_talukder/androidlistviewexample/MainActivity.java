package com.samad_talukder.androidlistviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] listItem = new String[]{"Australia", "Bangladesh", "India", "Pakistan", "England", "South-Africa"};
    private int[] listItemImage = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        List<HashMap<String, String>> mapList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            //create a hashmap to store the data in key value pair
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("text", listItem[i]);
            hashMap.put("image", Integer.toString(listItemImage[i]));
            //add the hashmap into arrayList
            mapList.add(hashMap);
        }
        //string array
        String[] from = new String[]{"text", "image"};
        //int array of views id's
        int[] to = new int[]{R.id.listItemText, R.id.listItemImage};
        /**
         * Make a new object of simpleAdapter
         * First parameter is context.Context gives the reference to the class.
         * Second parameter is arrayList of hashmap
         * Third parameter refers to the XML resource layout file
         * Fourth parameter is String[] from & int[] to.
         */
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, mapList, R.layout.item_array_list, from, to);
        listView.setAdapter(simpleAdapter);
        /**
         * Make a new object of arrayAdapter
         * First parameter is context
         * Second parameter is reference to the item_array_list.xml file
         * Third parameter have the id of the textView
         * Fourth parameter is the data source which is our string array
         * */
        /*
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.item_array_list, R.id.listItemText, listItem);
        listView.setAdapter(arrayAdapter);
        */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "" + listItem[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
