package com.leapfrog.inventorymanagementsystem.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.dashboard.DashBoardActivity;

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
        edtUsername.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        edtPassword.setError(getString(R.string.password_error));
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(LoginActivity.this, getString(R.string.login_success), Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, DashBoardActivity.class));
        finish();
    }

    @Override
    public void loginFailure() {
        Toast.makeText(LoginActivity.this, getString(R.string.invalid_login), Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, "Username :: admin \n Password :: admin", Toast.LENGTH_SHORT).show();
    }


}
