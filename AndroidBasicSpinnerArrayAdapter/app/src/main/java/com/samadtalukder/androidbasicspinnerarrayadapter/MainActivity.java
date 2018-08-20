package com.samadtalukder.androidbasicspinnerarrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String itemValue;
    Spinner spinnerVersion;
    String colors[] = {"Red","Blue","White","Yellow","Black", "Green","Purple","Orange","Grey"};
    public void addData(){ }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Item 1");
        arrayList.add("Item 2");
        arrayList.add("Item 3");
        arrayList.add("Item 4");
        arrayList.add("Item 5");
        //
        spinnerVersion = findViewById(R.id.spinner);
        //
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.simplerow,R.id.rowTV,arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.simplerow);
        spinnerVersion.setAdapter(arrayAdapter);
        spinnerVersion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Item: "+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.simplerow,R.id.rowTV,colors);
        arrayAdapter.setDropDownViewResource(R.layout.simplerow);
        spinnerVersion.setAdapter(arrayAdapter);*/
    }
}
