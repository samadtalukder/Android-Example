package com.samad.talukder.androidchartexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button lineChartBtn, barChartBtn, pieChartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setButtonClickAction();
    }

    private void initViews() {
        lineChartBtn = findViewById(R.id.lineChartBtn);
        barChartBtn = findViewById(R.id.barChartBtn);
        pieChartBtn = findViewById(R.id.pieChartBtn);
    }

    private void setButtonClickAction() {
        lineChartBtn.setOnClickListener(this);
        barChartBtn.setOnClickListener(this);
        pieChartBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.lineChartBtn:
                break;
            case R.id.barChartBtn:
                break;
            case R.id.pieChartBtn:
                startActivity(new Intent(MainActivity.this, PieChartActivity.class));
                break;
        }
    }
}
