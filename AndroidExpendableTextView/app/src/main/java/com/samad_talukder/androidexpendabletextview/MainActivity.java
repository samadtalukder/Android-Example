package com.samad_talukder.androidexpendabletextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView title_text,description_text;
    private ImageButton plus, minus;
    private ImageView ivDown,ivUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title_text = findViewById(R.id.title_text);
        description_text = findViewById(R.id.description_text);
        ivDown = findViewById(R.id.ivDown);
        ivUp = findViewById(R.id.ivUp);

        ivDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                description_text.setVisibility(View.VISIBLE);
                ivDown.setVisibility(View.GONE);
                ivUp.setVisibility(View.VISIBLE);
            }
        });

        ivUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                description_text.setVisibility(View.GONE);
                ivDown.setVisibility(View.VISIBLE);
                ivUp.setVisibility(View.GONE);
            }
        });


        //plus = findViewById(R.id.plus);
        //minus = findViewById(R.id.minus);

        /*plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plus.setVisibility(View.GONE);
                minus.setVisibility(View.VISIBLE);
                description_text.setMaxLines(Integer.MAX_VALUE);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                minus.setVisibility(View.GONE);
                plus.setVisibility(View.VISIBLE);
                description_text.setMaxLines(5);
            }
        });*/


    }
}
