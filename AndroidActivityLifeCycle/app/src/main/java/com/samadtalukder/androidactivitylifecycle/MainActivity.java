package com.samadtalukder.androidactivitylifecycle;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public String LOG_TAG = "AppLifeCycle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState!=null){
            String myString = savedInstanceState.getString("saveKey");
            Log.e(LOG_TAG, myString);
        }

        setContentView(R.layout.activity_main);

        int displayMode = getResources().getConfiguration().orientation;

        if (displayMode == 1) {
            Log.e(LOG_TAG, "ORIENTATION_PORTRAIT");
        } else {
            Log.e(LOG_TAG, "ORIENTATION_LANDSCAPE");
        }

        Log.e(LOG_TAG, "onCreate Call");
        Toast.makeText(this, "onCreate Call", Toast.LENGTH_SHORT).show();

        Button btnNext=findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(LOG_TAG, "onStart Call");
        Toast.makeText(this, "onStart Call", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(LOG_TAG, "onResume Call");
        Toast.makeText(this, "onResume Call", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(LOG_TAG, "onPause Call");
        Toast.makeText(this, "onPause Call Call", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(LOG_TAG, "onStop Call");
        Toast.makeText(this, "onStop Call", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(LOG_TAG, "onRestart Call");
        Toast.makeText(this, "onRestart Call", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(LOG_TAG, "onDestroy Call");
        Toast.makeText(this, "onDestroy Call", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.e(LOG_TAG, "onBackPressed Call");
        Toast.makeText(this, "onBackPressed Call", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("saveKey","Save Instance State");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String myString = savedInstanceState.getString("saveKey");
        Log.e(LOG_TAG, myString);
    }
}
