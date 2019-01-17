package com.samad.talukder.androidradiobuttonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup categoryRadioGroup;
    private RadioButton countUpRadioBtn, countDownRadioBtn;
    private Button submitBtn, countBtn;
    private TextView countResultTV;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryRadioGroup = findViewById(R.id.categoryRG);
        countUpRadioBtn = findViewById(R.id.countUpRB);
        countDownRadioBtn = findViewById(R.id.countDownRB);
        countBtn = findViewById(R.id.countButton);
        countResultTV = findViewById(R.id.countResultTV);

        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (countUpRadioBtn.isChecked()) {
                    count++;
                    countResultTV.setText(String.valueOf(count));

                }
                if (countDownRadioBtn.isChecked()) {
                    count--;
                    countResultTV.setText(String.valueOf(count));
                }
            }
        });

        submitBtn = findViewById(R.id.submitButton);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                // Get Selected Radio Button From RadioGroup
                int selectedRadioID = categoryRadioGroup.getCheckedRadioButtonId();
                // Find The RadioButton By Returned Id
                RadioButton selectRadio = findViewById(selectedRadioID);
                // Get Selected Radio Button text here
                String radioStr = selectRadio.getText().toString();
                */
                int selectedRadioID = categoryRadioGroup.getCheckedRadioButtonId();

                RadioButton selectRadio = findViewById(selectedRadioID);
                if (selectRadio != null && selectedRadioID > -1) {
                    Toast.makeText(MainActivity.this, "You Selected: " + selectRadio.getText().toString(), Toast.LENGTH_SHORT).show();
                    // Clears all selected radio buttons to default
                    categoryRadioGroup.clearCheck();
                }

            }
        });


    }
}
