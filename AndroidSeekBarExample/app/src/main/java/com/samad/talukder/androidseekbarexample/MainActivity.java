package com.samad.talukder.androidseekbarexample;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar, seekBar2, changeTextSizeWithSeekBar;
    private TextView showSeekBarProgress, showProgressTV2, changeTextSizeShowTV, fontSizeTV;
    private Button increaseButton, decreaseButton;
    private static final int DELTA_VALUE = 1;
    private static final int DEFAULT_FONT_SIZE = 12;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initialize views method
        initViews();
        // initialize views action method
        initAction();


    }

    private void initViews() {
        seekBar = findViewById(R.id.seekBar);
        seekBar2 = findViewById(R.id.seekBar2);
        changeTextSizeWithSeekBar = findViewById(R.id.changeTextSizeWithSeekBar);
        showSeekBarProgress = findViewById(R.id.showProgressTV);
        changeTextSizeShowTV = findViewById(R.id.changeTextSizeShowTV);
        fontSizeTV = findViewById(R.id.fontSizeTV);
        showProgressTV2 = findViewById(R.id.showProgressTV2);
        increaseButton = findViewById(R.id.increaseButton);
        decreaseButton = findViewById(R.id.decreaseButton);
    }

    private void initAction() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int maxValue = seekBar.getMax();
            int seekBarProgress = 0;

            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarProgress = progress;
                if (seekBarProgress <= 5) {
                    showSeekBarProgress.setTextColor(Color.parseColor("#2e7d32"));
                    showSeekBarProgress.setText("Progress: " + seekBarProgress + "/" + maxValue);
                } else {
                    showSeekBarProgress.setTextColor(Color.parseColor("#ff1744"));
                    showSeekBarProgress.setText("Progress: " + seekBarProgress + "/" + maxValue);
                }
                //showSeekBarProgress.setText("Progress: " + (seekBarProgress+10) + "/" + maxValue);
                //Toast.makeText(MainActivity.this, "SeekBar onProgressChanged: " + progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "SeekBar onStartTrackingTouch", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "SeekBar onStopTrackingTouch", Toast.LENGTH_SHORT).show();
            }
        });
        // SeekBar Simple Example
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                showProgressTV2.setText("Progress: " + progressValue + "/" + seekBar.getMax());
                showProgressTV2.setTextSize(progressValue);
                Toast.makeText(MainActivity.this, "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                showProgressTV2.setText("Progress: " + progress + "/" + seekBar.getMax());

            }
        });
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseProgress();
            }
        });
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseProgress();
            }
        });
        // change text size with SeekBar
        changeTextSizeWithSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressFontSize = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressFontSize = progress;
                changeTextSize(DEFAULT_FONT_SIZE + progressFontSize);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void changeTextSize(int fontSize) {
        fontSizeTV.setText("App Font Size : " + fontSize);
        changeTextSizeShowTV.setText("Android Studio");
        changeTextSizeShowTV.setTextSize(fontSize);
    }

    @SuppressLint("SetTextI18n")
    private void increaseProgress() {
        int incProgress = seekBar2.getProgress();
        if (incProgress + DELTA_VALUE > seekBar2.getMax()) {
            seekBar2.setProgress(0);
        } else {
            seekBar2.setProgress(incProgress + DELTA_VALUE);
        }
        showProgressTV2.setText("Progress: " + seekBar2.getProgress() + "/" + seekBar2.getMax());
    }

    @SuppressLint("SetTextI18n")
    private void decreaseProgress() {
        int decProgress = seekBar2.getProgress();
        if (decProgress - DELTA_VALUE < 0) {
            seekBar2.setProgress(0);
        } else {
            seekBar2.setProgress(decProgress - DELTA_VALUE);
        }
        showProgressTV2.setText("Progress: " + seekBar2.getProgress() + "/" + seekBar2.getMax());
    }
}
