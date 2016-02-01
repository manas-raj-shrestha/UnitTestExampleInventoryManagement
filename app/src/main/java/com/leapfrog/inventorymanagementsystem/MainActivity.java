package com.leapfrog.inventorymanagementsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    MainActivityPresenter mainActivityPresenter;

    @Bind(R.id.edt_item_code)
    EditText edtItemCode;

    @Bind(R.id.edt_item_quantity)
    EditText edtItemQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mainActivityPresenter = new MainActivityPresenter(this);
    }

    @Override
    public int getQuantity() {
        return Integer.parseInt(edtItemQuantity.getText().toString());
    }

    @Override
    public String getItemCode() {
        return edtItemCode.getText().toString();
    }

    @Override
    public void purchaseSuccessful() {
        Toast.makeText(MainActivity.this, "Purchase Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void purchaseFailure() {
        Toast.makeText(this, "Item is not available", Toast.LENGTH_SHORT).show();
    }

    public void buyItem(View view) {
            mainActivityPresenter.buyItems();
    }
}
