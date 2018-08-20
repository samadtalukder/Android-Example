package com.samadtalukder.androidcreatecardviewprogrammatically;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RelativeLayout relativeLayout;
    private Button createCVBtn;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the application context
        context = getApplicationContext();
        // Change the action bar color
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        // Get the widgets reference from XML layout
        relativeLayout = findViewById(R.id.rl);
        createCVBtn = findViewById(R.id.btn);
        //
        createCVBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize a new CardView
                CardView cardView = new CardView(context);
                // Set the CardView layoutParams
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
                cardView.setLayoutParams(layoutParams);
                // Set CardView corner radius
                cardView.setRadius(10);
                // Set cardView content padding
                cardView.setContentPadding(15,15,15,15);
                // Set a background color for CardView
                cardView.setBackgroundColor(Color.parseColor("#FFC6D6C3"));
                // Set the CardView maximum elevation
                cardView.setMaxCardElevation(15);
                // Set CardView elevation
                cardView.setCardElevation(10);

                // Initialize a new TextView to put in CardView
                TextView textView = new TextView(context);
                textView.setLayoutParams(layoutParams);
                textView.setText("Test Cardview");
                textView.setTextSize(20);
                textView.setTextColor(Color.RED);
                // Put the TextView in CardView
                cardView.addView(textView);
                // Finally, add the CardView in root layout
                relativeLayout.addView(cardView);
            }
        });

    }
}
