package com.leapfrog.inventorymanagementsystem.presenters;

import com.leapfrog.inventorymanagementsystem.views.LoginActivityView;

/**
 * Presenter for login activity
 * Handle all the actions of login view via {@link com.leapfrog.inventorymanagementsystem.views.LoginActivityView}
 */
public class LoginActivityPresenter {
    String username = "zeppelin";
    String password = "asdf";

    LoginActivityView loginActivityView;

    public LoginActivityPresenter(LoginActivityView loginActivityView) {
        this.loginActivityView = loginActivityView;
    }

    /**
     * Method to check the username and password and determine login success or failure
     */
    public void login() {

        String userName = loginActivityView.getUsername();
        String password = loginActivityView.getPassword();

        if (userName.isEmpty()) {
            loginActivityView.setUsernameError();
        } else if (password.isEmpty()) {
            loginActivityView.setPasswordError();
        }else {
            if(userName.toLowerCase().contentEquals(this.username) && password.toLowerCase().contentEquals(this.password)){
                loginActivityView.loginSuccess();
            }else {
                loginActivityView.loginFailure();
            }
        }

    }

}
