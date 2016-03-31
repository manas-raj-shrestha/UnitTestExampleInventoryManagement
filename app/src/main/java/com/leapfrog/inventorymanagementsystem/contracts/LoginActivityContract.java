package com.leapfrog.inventorymanagementsystem.contracts;

/**
 * Created by ManasShrestha on 2/2/16.
 */
public interface LoginActivityContract {

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
