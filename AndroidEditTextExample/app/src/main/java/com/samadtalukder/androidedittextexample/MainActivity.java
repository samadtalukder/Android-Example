package com.samadtalukder.androidedittextexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText fullNameEdtTxt,ageEdtTxt;
    private EditText editText;
    private Button clickBtn;
    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullNameEdtTxt = findViewById(R.id.fullName_edtxt);
        ageEdtTxt = findViewById(R.id.age_edtxt);
        clickBtn = findViewById(R.id.click_btn);
        editText = findViewById(R.id.edtxt);
        showText = findViewById(R.id.show_text);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String editTextOutput = editText.getText().toString();
                showText.setText("You Type: "+editTextOutput);
                //Toast.makeText(MainActivity.this, ""+editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowInputResult();
            }
        });
    }

    private void ShowInputResult() {
        String fullName = fullNameEdtTxt.getText().toString();
        String age = ageEdtTxt.getText().toString();

        if (fullNameEdtTxt.getText().toString().trim().isEmpty() && ageEdtTxt.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Input Field Is Empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"Full Name: "+fullName+"\nAge: "+String.valueOf(age),Toast.LENGTH_SHORT).show();
        }
    }
}
