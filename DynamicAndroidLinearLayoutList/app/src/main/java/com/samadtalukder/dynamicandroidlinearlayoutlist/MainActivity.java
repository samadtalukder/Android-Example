package com.samadtalukder.dynamicandroidlinearlayoutlist;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        for (int i = 0; i<=10; i++){
            View layoutChild = getLayoutInflater().inflate(R.layout.row,null);

            TextView textView1 = layoutChild.findViewById(R.id.colOne);
            TextView textView2 = layoutChild.findViewById(R.id.colTwo);
            //
            textView1.setText("Key"+i);
            textView2.setText("Value"+i);
            //
            if (i % 2 == 0){
                textView1.setBackgroundColor(Color.parseColor("#CCCCCC"));
                textView2.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }else {
                textView1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                textView2.setBackgroundColor(Color.parseColor("#CCCCCC"));
            }
            linearLayout.addView(layoutChild);
        }
    }
}
