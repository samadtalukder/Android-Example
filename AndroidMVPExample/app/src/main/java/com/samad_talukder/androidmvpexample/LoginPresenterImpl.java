package com.samad_talukder.androidmvpexample;

import android.text.TextUtils;

import com.samad_talukder.androidmvpexample.model.ILoginContract;

public class LoginPresenterImpl implements ILoginContract.ILoginPresenter {

    private ILoginContract.ILoginView iLoginView;

    public LoginPresenterImpl(ILoginContract.ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void handleLogin(String email, String password) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            iLoginView.showValidationError();
        } else {
            if (email.matches("admin@mail.com") && password.matches("admin")) {
                iLoginView.loginSuccessfully();
            } else {
                iLoginView.loginFailed();
            }

        }
    }
}
