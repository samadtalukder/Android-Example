package com.samad.talukder.androidalertdialogexample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private Button btnAlertDialogOne, btnAlertDialogTwo, btnAlertDialogThree, btnAlertDialogWithRadioBtn,
            btnAlertDialogWithCheckbox, btnAlertDialogUploadAction, btnAlertDialogInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlertDialogOne = findViewById(R.id.btnAlertDialogOne);
        btnAlertDialogTwo = findViewById(R.id.btnAlertDialogTwo);
        btnAlertDialogThree = findViewById(R.id.btnAlertDialogThree);
        btnAlertDialogWithRadioBtn = findViewById(R.id.btnAlertDialogWithRadioBtn);
        btnAlertDialogWithCheckbox = findViewById(R.id.btnAlertDialogWithCheckbox);
        btnAlertDialogUploadAction = findViewById(R.id.btnAlertDialogUploadAction);
        btnAlertDialogInfo = findViewById(R.id.btnAlertDialogInfo);

        btnAlertDialogOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show One Alert Dialog Button Clicked
                showOneAlertDialogButtonClicked();
            }
        });

        btnAlertDialogTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show Two Alert Dialog Button Clicked
                showTwoAlertDialogButtonClicked();
            }
        });
        btnAlertDialogThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show Three Alert Dialog Button Clicked
                showThreeAlertDialogButtonClicked();
            }
        });
        btnAlertDialogWithRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show Three Alert Dialog Button Clicked
                showRadioButtonInAlertDialog();
            }
        });
        btnAlertDialogWithCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show Three Alert Dialog Button Clicked
                showCheckBoxInAlertDialog();
            }
        });
        btnAlertDialogUploadAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show Three Alert Dialog Button Clicked
                showUploadActionInAlertDialog();
            }
        });
        btnAlertDialogInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show Three Alert Dialog Button Clicked
                Dialog dialog = new DialogUtils(MainActivity.this).dialogInfo("Info", getString(R.string.content_will_be_here), "OK", R.drawable.ic_info, new CallBackDialog() {
                    @Override
                    public void onPositiveAction(Dialog dialog) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onNegativeAction(Dialog dialog) {

                    }

                    @Override
                    public void onNeutralAction(Dialog dialog) {

                    }

                    @Override
                    public void onClick(View v) {

                    }
                });
                dialog.show();
            }
        });

    }

    private void showUploadActionInAlertDialog() {
        final String[] items = {"Take Photo", "Choose from Gallery", "Cancel"};
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Chose Action");
        alertBuilder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (items[which].equals("Take Photo")) {
                    getTakePicFromCamera();
                } else if (items[which].equals("Choose from Gallery")) {
                    getPicFromGallery();
                } else if (items[which].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });

        alertBuilder.show();
    }

    private void getPicFromGallery() {

    }

    private void getTakePicFromCamera() {
    }

    private void showCheckBoxInAlertDialog() {
        // setup the alert builder
        AlertDialog.Builder alBuilder = new AlertDialog.Builder(this);
        alBuilder.setTitle("Choose Gender");
        // add a radio button list
        final String[] gender = {"Male", "Female", "Others"};
        final boolean checkdItem[] = {false, false, false};
        alBuilder.setMultiChoiceItems(gender, checkdItem, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                /*if (gender[which].equals("Male")){
                    Toast.makeText(MainActivity.this, "YoYo", Toast.LENGTH_SHORT).show();
                }*/
                Toast.makeText(MainActivity.this, "" + gender[which] + "-> " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });
        // add a button
        alBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something
            }
        });

        // create and show the alert dialog
        AlertDialog alertDialog = alBuilder.create();
        alertDialog.show();
    }

    private void showRadioButtonInAlertDialog() {
        // setup the alert builder
        AlertDialog.Builder alBuilder = new AlertDialog.Builder(this);
        alBuilder.setTitle("Choose Gender");
        // add a radio button list
        final String[] gender = {"Male", "Female", "Others"};
        final int checkdItem = 0;
        alBuilder.setSingleChoiceItems(gender, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "" + gender[which], Toast.LENGTH_SHORT).show();
            }
        });
        // add a button
        alBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something
            }
        });

        // create and show the alert dialog
        AlertDialog alertDialog = alBuilder.create();
        alertDialog.show();
    }


    private void showOneAlertDialogButtonClicked() {
        // setup the alert builder
        AlertDialog.Builder alBuilder = new AlertDialog.Builder(this);
        alBuilder.setTitle("Alert Title");
        alBuilder.setMessage("Alert Message");
        // add a button
        alBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something
            }
        });
        // create and show the alert dialog
        AlertDialog alertDialog = alBuilder.create();
        alertDialog.show();

    }

    private void showTwoAlertDialogButtonClicked() {
        // setup the alert builder
        AlertDialog.Builder alBuilder = new AlertDialog.Builder(this);
        alBuilder.setTitle("Alert Title");
        alBuilder.setMessage("Alert Message");
        // add a button
        alBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something
            }
        });
        alBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something
            }
        });
        // create and show the alert dialog
        AlertDialog alertDialog = alBuilder.create();
        alertDialog.show();

    }

    private void showThreeAlertDialogButtonClicked() {
        // setup the alert builder
        AlertDialog.Builder alBuilder = new AlertDialog.Builder(this);
        alBuilder.setTitle("Alert Title");
        alBuilder.setMessage("Alert Message");
        // add a button
        alBuilder.setPositiveButton("Launch", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something
            }
        });
        alBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something
            }
        });
        alBuilder.setNeutralButton("Remind me later", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something
            }
        });
        // create and show the alert dialog
        AlertDialog alertDialog = alBuilder.create();
        alertDialog.show();
    }

}
