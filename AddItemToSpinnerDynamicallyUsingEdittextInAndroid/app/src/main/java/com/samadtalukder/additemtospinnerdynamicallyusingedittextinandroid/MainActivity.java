package com.samadtalukder.additemtospinnerdynamicallyusingedittextinandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private EditText editText;
    private ImageView addBtn;
    private String spinnerItem[]={"Java","Python"};
    private String getTextFromInput;
    private List<String> showAddList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner1);
        editText = findViewById(R.id.editText1);
        addBtn = findViewById(R.id.button1);
        //
        showAddList = new ArrayList<>(Arrays.asList(spinnerItem));
        arrayAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.row_spinners_dropdown,showAddList);
        arrayAdapter.setDropDownViewResource(R.layout.custom_spinner_textview);
        spinner.setAdapter(arrayAdapter);
        //
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTextFromInput = editText.getText().toString();
                showAddList.add(getTextFromInput);
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Item Add: "+getTextFromInput, Toast.LENGTH_SHORT).show();
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedSpinnerItem = (String) adapterView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),"Selected: "+selectedSpinnerItem,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
