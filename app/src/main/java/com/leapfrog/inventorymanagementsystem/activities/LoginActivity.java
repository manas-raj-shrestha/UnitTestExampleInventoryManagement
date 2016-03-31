package com.leapfrog.inventorymanagementsystem.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.presenters.LoginActivityPresenter;
import com.leapfrog.inventorymanagementsystem.contracts.LoginActivityContract;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Screen for login
 */
public class LoginActivity extends AppCompatActivity implements LoginActivityContract.Views {

    @Bind(R.id.edt_password)
    EditText edtPassword;

    @Bind(R.id.edt_username)
    EditText edtUsername;

    LoginActivityContract.UserInteractions loginActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);

        loginActivityPresenter = new LoginActivityPresenter(this);
        loginSuccess();
    }

    @Override
    public String getUsername() {
        String username = null;

        if (edtUsername.getText() != null)
            username = edtUsername.getText().toString();

        return username;
    }

    @Override
    public String getPassword() {
        String password = null;
        if (edtPassword.getText() != null)
            password = edtPassword.getText().toString();

        return password;
    }

    @Override
    public void setUsernameError() {
        edtUsername.setError("Username cannot be empty.");
    }

    @Override
    public void setPasswordError() {
        edtPassword.setError("Password cannot be empty");
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, DashBoardActivity.class));
    }

    @Override
    public void loginFailure() {
        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
    }

    /**
     * Called in onclick of done button
     *
     * @param view
     */
    public void login(View view) {
        loginActivityPresenter.attemptLogin();
    }

    public void forgotPassword(View view) {
        Toast.makeText(this, "Username :: zeppelin \n Password :: asdf", Toast.LENGTH_SHORT).show();
    }

}
