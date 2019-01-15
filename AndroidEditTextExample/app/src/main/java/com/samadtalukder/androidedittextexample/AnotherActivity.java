package com.samadtalukder.androidedittextexample;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity {
    private AppCompatEditText userName, password, textChanged;
    private AppCompatButton login;
    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        showText = findViewById(R.id.showChangeTextTV);
        textChanged = findViewById(R.id.textChangedET);
        textChanged.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showText.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                showText.setTextColor(Color.WHITE);
                showText.setText(textChanged.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        userName = findViewById(R.id.userNameET);
        password = findViewById(R.id.passwordET);
        login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameStr = userName.getText().toString();
                String userPasswordStr = password.getText().toString();
                if ((!userNameStr.isEmpty()) || (!userPasswordStr.isEmpty())) {
                    Toast.makeText(AnotherActivity.this, "Username: " + userNameStr + "\n Password: " + userPasswordStr, Toast.LENGTH_SHORT).show();
                    userName.getText().clear();
                    password.getText().clear();
                } else {
                    userName.setError("Enter UserName");
                    password.setError("Enter Password");
                }
            }
        });
    }
}
