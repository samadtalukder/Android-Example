package com.samad.talukder.androidcheckboxexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBox, c, java, python, checkboxAll;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Accept your request", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Cancel your request", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //
        c = findViewById(R.id.cCheckbox);
        java = findViewById(R.id.javaCheckbox);
        python = findViewById(R.id.pythonCheckbox);
        checkboxAll = findViewById(R.id.checkboxAll);
        checkboxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = (CheckBox) v;
                Boolean isSelected = checkBox.isChecked();

                c.setChecked(isSelected);
                java.setChecked(isSelected);
                python.setChecked(isSelected);
            }
        });
        submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String submitData = "";
                double languageRating = 0;
                StringBuilder submitData = new StringBuilder();
                if (c.isChecked()) {
                    languageRating = 4.6;
                    submitData.append("C").append("->").append(languageRating);
                }
                if (java.isChecked()) {
                    languageRating = 4.7;
                    submitData.append("\nJava").append("->").append(languageRating);
                }
                if (python.isChecked()) {
                    languageRating = 4.8;
                    submitData.append("\nPython").append("->").append(languageRating);
                }

                Toast.makeText(MainActivity.this, "Your Favorite: \n" + submitData, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
