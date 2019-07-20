package com.samad_talukder.androidmvpexample.model;

public interface ILoginContract {

    interface ILoginPresenter {
        void handleLogin(String username, String password);
    }

    interface ILoginView {
        void showValidationError();

        void loginSuccessfully();

        void loginFailed();
    }
}
