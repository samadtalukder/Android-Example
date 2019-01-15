package com.samad.talukder.androidtextviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Create TextView Programmatically*/
        // Get the widgets reference from XML layout
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        // Create a TextView programmatically
        TextView textView = new TextView(this);
        // Create a LayoutParams for TextView
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // Apply the layout parameters to TextView
        textView.setLayoutParams(layoutParams);
        textView.setText("TextView Programmatically");
        textView.setTextSize(18);
        textView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        textView.setPadding(5, 5, 5, 5);
        textView.setAllCaps(true);
        // Add newly created TextView to parent view group (LinearLayout)
        linearLayout.addView(textView);

    }
}
