package com.samad_talukder.androidsnackbarexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button normalSnackbarBtn, actionSnackbarBtn, customSnackbarWithActionBtn, customSnackbarDifferentActionsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        normalSnackbarBtn = findViewById(R.id.normalSnackbarBtn);
        actionSnackbarBtn = findViewById(R.id.actionSnackbarBtn);
        customSnackbarWithActionBtn = findViewById(R.id.customSnackbarWithActionBtn);
        customSnackbarDifferentActionsBtn = findViewById(R.id.customSnackbarDifferentActionsBtn);

        normalSnackbarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Show Snack Bar Text", Snackbar.LENGTH_LONG).setDuration(3000).show();
            }
        });
        // Show Custom Sncak Bar Method
        showCustomSnackbar();
        //
        actionSnackbarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Go To Internet Settings", Snackbar.LENGTH_LONG)
                        .setAction("Settings", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                            }
                        })
                        .show();
            }
        });
        //
        customSnackbarDifferentActionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customSnackbarDifferentActions();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void customSnackbarDifferentActions() {
        String snackMessage = "Marked as read";
        // create the snackbar
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final Snackbar snackbar = Snackbar.make(this.findViewById(android.R.id.content), "", Snackbar.LENGTH_LONG);
        // Get the Snackbar layout view
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        // Set snackbar layout params
        int navBarHeight = getNavBarHeight(this);
        FrameLayout.LayoutParams parentParams = (FrameLayout.LayoutParams) snackbarLayout.getLayoutParams();
        /*parentParams.setMargins(0, 0, 0, 0-navBarHeight+55);
        snackbarLayout.setLayoutParams(parentParams);*/
        snackbarLayout.setPadding(0, 0, 0, 0);
        snackbarLayout.setLayoutParams(parentParams);
        // Inflate our custom view
        View customSnackView = getLayoutInflater().inflate(R.layout.custom_snackbar_two_different_actions, null);
        // Configure our custom view
        TextView messageTextView = customSnackView.findViewById(R.id.messageTextView);
        messageTextView.setText(snackMessage);
        //
        TextView oneTextView = customSnackView.findViewById(R.id.oneTextView);
        oneTextView.setText("UNDO");
        oneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Allow Clicked", Toast.LENGTH_SHORT).show();
                snackbar.dismiss();
            }
        });
        //
        TextView twoTextView = customSnackView.findViewById(R.id.twoTextView);
        twoTextView.setText("DISMISS");
        twoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Deny Clicked", Toast.LENGTH_SHORT).show();
                snackbar.dismiss();
            }
        });
        // Add our custom view to the Snackbar's layout
        snackbarLayout.addView(customSnackView, layoutParams);
        // Show the Snackbar
        snackbar.show();
    }

    public static int getNavBarHeight(Context context) {
        int result = 0;
        int resourceID = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceID > 0) {
            result = context.getResources().getDimensionPixelOffset(resourceID);
        }
        return result;
    }

    private void showCustomSnackbar() {
        customSnackbarWithActionBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                // Create a Snackbar instance, the message is displayed at the left side.
                Snackbar showCustomSnackbar = Snackbar.make(v, "Check your internet connection", Snackbar.LENGTH_SHORT);
                // Set action
                showCustomSnackbar.setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                                .setIcon(R.mipmap.ic_launcher)
                                .setTitle("Show Alert Title")
                                .setMessage("Show Alert Dialog Message")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .setNegativeButton("NO", null)
                                .create();
                        alertDialog.show();
                        //Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
                    }
                });
                // Set action text color
                showCustomSnackbar.setActionTextColor(getResources().getColor(R.color.colorBlack));
                // Get Snackbar view
                Snackbar.SnackbarLayout snackbarLayoutView = (Snackbar.SnackbarLayout) showCustomSnackbar.getView();
                // Set action background color
                snackbarLayoutView.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                // Set message text color
                TextView customSnackMessageTv = snackbarLayoutView.findViewById(android.support.design.R.id.snackbar_text);
                //Button customSnackButton = snackbarLayoutView.findViewById(android.support.design.R.id.snackbar_action);
                customSnackMessageTv.setTextColor(getResources().getColor(R.color.colorWhite));
                /*customSnackButton.setTextColor(getResources().getColor(R.color.colorWhite));
                customSnackButton.setBackgroundColor(getResources().getColor(R.color.colorBlack));*/
                //customSnackMessageTv.setTextSize(18);
                showCustomSnackbar.show();
            }
        });
    }
}
