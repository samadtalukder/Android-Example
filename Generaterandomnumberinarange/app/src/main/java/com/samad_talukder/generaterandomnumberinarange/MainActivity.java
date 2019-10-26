package com.samad_talukder.generaterandomnumberinarange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tvShowRandomNumber;
    private Button btnGenerateRandomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShowRandomNumber = findViewById(R.id.tvShowRandomNumber);
        btnGenerateRandomNumber = findViewById(R.id.btnGenerateRandomNumber);

        btnGenerateRandomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandomNumber();
            }
        });
    }

    private void generateRandomNumber() {

        Random random = new Random();

        int minimumNum = 1;
        int maximumNum = 20;

        int randomNumber = random.nextInt((maximumNum - minimumNum) + 1) + minimumNum;

        tvShowRandomNumber.setText(String.valueOf(randomNumber));
        // tvShowRandomNumber.setText(randomNumber+"");
    }
}
