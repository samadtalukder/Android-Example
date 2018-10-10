package com.samadtalukder.androidloadingdialoganimation;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private CustomLoadingDialog customLoadingDialog;
    private Button showDialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customLoadingDialog = new CustomLoadingDialog(this);
        showDialogBtn = findViewById(R.id.showDialogBtn);
        showDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customLoadingDialog.showDialog();
                final Handler dialogHandler = new Handler();
                dialogHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        customLoadingDialog.hideDialog();
                    }
                },5000);
            }
        });
        showCustomLoadingDialog(showDialogBtn);
    }
    public void showCustomLoadingDialog(View view){
        customLoadingDialog.showDialog();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                customLoadingDialog.hideDialog();
            }
        },6000);
    }
}
