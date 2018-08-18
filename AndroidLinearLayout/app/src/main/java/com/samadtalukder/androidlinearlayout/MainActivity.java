package com.samadtalukder.androidlinearlayout;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearlayout;
    private Button button;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //added LinearLayout
        linearlayout = findViewById(R.id.linearlayout);
        // added layout margin
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearlayout.getLayoutParams();
        marginLayoutParams.rightMargin = 10;
        marginLayoutParams.leftMargin = 10;
        marginLayoutParams.topMargin = 10;
        marginLayoutParams.bottomMargin = 10;

        for (int i = 0; i < 3; i++) {
            //Layout params for Button
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            // added Button in loop
            button = new Button(MainActivity.this);
            // button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            button.setText("Button Programmatically " + i);
            button.setTextSize(14);
            button.setLayoutParams(params);
            params.setMargins(10, 10, 10, 10);
            button.setBackgroundColor(getResources().getColor(R.color.buttonColor));
            button.setTextColor(getResources().getColor(R.color.textColor));
            button.setPadding(5, 5, 5, 5);
            //added the Button to LinearLayout
            linearlayout.addView(button);
        }
    }
}
