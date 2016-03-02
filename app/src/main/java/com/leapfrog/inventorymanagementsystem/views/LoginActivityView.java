package com.leapfrog.inventorymanagementsystem.views;

/**
 * Created by ManasShrestha on 2/2/16.
 */
public interface LoginActivityView {

    interface Views {

        String getUsername();

        String getPassword();

        void setUsernameError();

        void setPasswordError();

        void loginSuccess();

        void loginFailure();
    }

    interface UserInteractions{

        void attemptLogin();
    }

}
