package com.samad_talukder.androidmvpexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.samad_talukder.androidmvpexample.model.ILoginContract;

public class MainActivity extends AppCompatActivity implements ILoginContract.ILoginView {
    private ILoginContract.ILoginPresenter iLoginPresenter;
    private EditText etUserEmail, etUserPassword;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        iLoginPresenter = new LoginPresenterImpl(this);

        clickSubmitAction();
    }

    private void clickSubmitAction() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String putUserEmailStr = etUserEmail.getText().toString();
                String putUserPasswordStr = etUserPassword.getText().toString();

                iLoginPresenter.handleLogin(putUserEmailStr, putUserPasswordStr);
            }
        });
    }

    private void initViews() {
        etUserEmail = findViewById(R.id.etUserEmail);
        etUserPassword = findViewById(R.id.etUserPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
    }

    @Override
    public void showValidationError() {
        etUserEmail.setError("Please Enter Valid Email");
        etUserPassword.setError("Please Enter Correct Password");
        //Toast.makeText(this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccessfully() {
        Toast.makeText(this, "Login SuccessFully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
    }
}
