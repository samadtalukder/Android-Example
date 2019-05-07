package com.samad_talukder.androidsharedpreferencesexample;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private PreferencesHelper preferencesHelper;
    private EditText nameEditText, mobileNoEditText, emailEditText;
    private Button saveButton, clearButton;
    private TextView showTextTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferencesHelper = new PreferencesHelper(this);
        nameEditText = findViewById(R.id.nameEditText);
        mobileNoEditText = findViewById(R.id.mobileNoEditText);
        emailEditText = findViewById(R.id.emailEditText);
        saveButton = findViewById(R.id.saveButton);
        clearButton = findViewById(R.id.clearButton);
        showTextTV = findViewById(R.id.showTextTV);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveName();
                showDisplayName();
            }
        });
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferencesHelper.clearPreferences();
                nameEditText.setText("");
                mobileNoEditText.setText("");
                emailEditText.setText("");
            }
        });
    }

    private void saveName() {
        String getName = nameEditText.getText().toString();
        String getMobileNo = mobileNoEditText.getText().toString();
        String getEmail = emailEditText.getText().toString();

        if (getName.isEmpty()) {
            nameEditText.setError("Please Enter Name");
            nameEditText.requestFocus();
            return;
        } else if (getMobileNo.isEmpty()) {
            mobileNoEditText.setError("Please Enter Mobile No");
            mobileNoEditText.requestFocus();
            return;
        } else if (getEmail.isEmpty()) {
            emailEditText.setError("Please Enter Email");
            emailEditText.requestFocus();
            return;
        }

        preferencesHelper.setNAME_KEY(getName);
        preferencesHelper.setIntPreferences(PreferencesHelper.MOBILE_KEY, Integer.parseInt(getMobileNo));
        preferencesHelper.setStringPreferences(PreferencesHelper.EMAIL_KEY, getEmail);

        nameEditText.setText("");
        mobileNoEditText.setText("");
        emailEditText.setText("");
    }

    @SuppressLint("SetTextI18n")
    private void showDisplayName() {
        showTextTV.setVisibility(View.VISIBLE);
        showTextTV.setText(
                "Save Text: " + preferencesHelper.getNAME_KEY() + "\n" +
                        "Mobile No: " + preferencesHelper.getIntPreferences(PreferencesHelper.MOBILE_KEY) + "\n" +
                        "Email: " + preferencesHelper.getStringPreferences(PreferencesHelper.EMAIL_KEY)
        );
    }
}
