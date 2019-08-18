package com.samad_talukder.buttonclickcounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etName;
    private Button btnEnter;
    private TextView tvShowName;
    private int numOfTimesClick = 0;
    public String TAG = "ActivityLifeCycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Created onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnEnter = findViewById(R.id.btnEnter);
        tvShowName = findViewById(R.id.tvShowName);

        tvShowName.setText("");

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // numOfTimesClick += 1;

                String strName = etName.getText().toString();
                tvShowName.append(strName + "\n");

                // String countResult = "\n The button got tapped " + strName + " " + numOfTimesClick + " time";

                /*
                if (numOfTimesClick != 1) {

                    countResult += "empty";

                } else {

                    countResult += "\n";
                    tvShowName.append(countResult);
                }
                */

            }
        };

        btnEnter.setOnClickListener(onClickListener);

        tvShowName.setMovementMethod(new ScrollingMovementMethod());
        Log.e(TAG, "onCreate Out");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart In");
        super.onStart();
        Log.e(TAG, "onStart Out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume In");
        super.onResume();
        Log.e(TAG, "onResume Out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause In");
        super.onPause();
        Log.e(TAG, "onPause Out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart In");
        super.onRestart();
        Log.e(TAG, "onRestart Out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop In");
        super.onStop();
        Log.e(TAG, "onStop Out");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy In");
        super.onDestroy();
        Log.e(TAG, "onDestroy Out");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState In");
        outState.putString("TEXT_CONTENTS", tvShowName.getText().toString());
        super.onSaveInstanceState(outState);

        Log.e(TAG, "onSaveInstanceState Out");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState In");
        super.onRestoreInstanceState(savedInstanceState);
        String saveState = savedInstanceState.getString("TEXT_CONTENTS");
        tvShowName.append(saveState);
        Log.e(TAG, "onRestoreInstanceState Out");
    }
}
