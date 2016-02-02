package com.leapfrog.inventorymanagementsystem.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.views.LoginActivityView;

import butterknife.Bind;

/**
 * Created by ManasShrestha on 2/1/16.
 */
public class LoginActivity extends AppCompatActivity implements LoginActivityView {

    @Bind(R.id.edt_password)
    EditText edtPassword;

    @Bind(R.id.edt_username)
    EditText edtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    @Override
    public String getUsername() {
        return edtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return edtPassword.getText().toString();
    }

    @Override
    public void setUsernameError() {
        edtUsername.setError("Please Enter Username");
    }

    @Override
    public void setPasswordError() {
        edtPassword.setError("Please Enter Password");
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }
}
