package com.samad_talukder.androidcustomalertdialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogClickInterface {
    private int dialogIdentifier = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomAlertDialog.getInstance().showConfirmDialog("Your Title", "Your Title", "OK", "Cancel", this, dialogIdentifier);
        findViewById(R.id.successDialogBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSuccessAlertDialog();
            }
        });

    }

    private void showSuccessAlertDialog() {
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, viewGroup, false);
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setView(dialogView);
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();


    }

    @Override
    public void onClickPositiveButton(DialogInterface pDialog, int pDialogIdentifier) {
        if (dialogIdentifier == 0) {
            Toast.makeText(this, "Clicked on positive button..!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClickNegativeButton(DialogInterface pDialog, int pDialogIdentifier) {
        if (dialogIdentifier == 0) {
            Toast.makeText(this, "Clicked on positive button..!", Toast.LENGTH_SHORT).show();
        }

    }
}
