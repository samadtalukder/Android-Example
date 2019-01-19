package com.samad.talukder.androidprogressbarexample;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    int progressStatus = 0;
    private Handler handler = new Handler();
    private TextView progressTextView;
    private Button showProgressBtn;
    private ProgressDialog progressDialog;
    private long fileSize = 0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // circular progress bar dialog
        progressBar = findViewById(R.id.progress_circular);
        progressBar.setMin(0);
        progressBar.setMax(100);
        progressTextView = findViewById(R.id.showProgressTV);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 80) {
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            progressTextView.setText(progressStatus + "%");
                        }
                    });
                    try {
                        Thread.sleep(26);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        }).start();
        // when click button then show progress bar dialog
        showProgressBtn = findViewById(R.id.showProgressBtn);
        showProgressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // creating progress bar dialog
                progressDialog = new ProgressDialog(v.getContext());
                progressDialog.setCancelable(true);
                progressDialog.setMessage("Downloading...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setProgress(0);
                progressDialog.setMax(100);
                Drawable customDrawable = getResources().getDrawable(R.drawable.custom_progressbar);
                progressDialog.setProgressDrawable(customDrawable);
                progressDialog.show();
                // reset progress bar status
                progressStatus = 0;
                //reset filesize
                fileSize = 0;

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus < 100) {
                            //  performing operation
                            progressStatus = fileDownloadingStatus();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            // Updating the progress bar
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressDialog.setProgress(progressStatus);
                                }
                            });
                        }
                        // when, file is downloaded 100%,
                        if (progressStatus >= 100) {
                            // sleep for  1 seconds, so that you can see the 100% of file download
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            // close the progress bar dialog
                            progressDialog.dismiss();
                        }
                    }
                }).start();
            }

            private int fileDownloadingStatus() {
                while (fileSize <= 1000000) {

                    fileSize++;

                    if (fileSize == 100000) {
                        return 10;
                    } else if (fileSize == 200000) {
                        return 20;
                    } else if (fileSize == 300000) {
                        return 30;
                    } else if (fileSize == 400000) {
                        return 40;
                    } else if (fileSize == 500000) {
                        return 50;
                    } else if (fileSize == 600000) {
                        return 60;
                    } else if (fileSize == 700000) {
                        return 70;
                    } else if (fileSize == 800000) {
                        return 80;
                    } else if (fileSize == 900000) {
                        return 90;
                    }
                }

                return 100;
            }

        });
    }
}
