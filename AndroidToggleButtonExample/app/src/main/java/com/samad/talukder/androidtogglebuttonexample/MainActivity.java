package com.samad.talukder.androidtogglebuttonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Switch switchWifi;
    private ToggleButton wifiToggleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchWifi = findViewById(R.id.wifiSwitch);
        switchWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String status = isChecked ? "Wi-Fi On" : "Wi-Fi Off";
                Toast.makeText(MainActivity.this, ""+status, Toast.LENGTH_SHORT).show();
            }
        });
        wifiToggleBtn = findViewById(R.id.wifiToggle);
        wifiToggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String status = isChecked ? "Wi-Fi Connect" : "Wi-Fi Disconnect";
                Toast.makeText(MainActivity.this, ""+status, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
