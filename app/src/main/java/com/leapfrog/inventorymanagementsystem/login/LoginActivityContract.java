package com.leapfrog.inventorymanagementsystem.login;

/**
 * View and user interaction contract for login screen
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

    interface UserInteractions {

        void attemptLogin();
    }

}