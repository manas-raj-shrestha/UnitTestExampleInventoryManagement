package com.leapfrog.inventorymanagementsystem.payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.dashboard.DashBoardActivity;
import com.stripe.exception.AuthenticationException;

import butterknife.Bind;

public class PaymentActivity extends AppCompatActivity implements PaymentView, View.OnClickListener {

    private EditText edtFullName, edtCardNumber, edtCardCVC, edtCardExpiryMonth, edtCardExpiryYear;

    private Button btnMakePayment;

    private ProgressBar payProgressBar;

    private String fullName, cardNumber, cardCVC;
    private int cardExpiryMonth, cardExpiryYear;

    private PaymentPresenter paymentPresenter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        setToolbar();

        paymentPresenter = new PaymentPresenterImplementation(this);

        initViews();

    }

    private void initViews() {
        edtFullName = (EditText) findViewById(R.id.edt_full_name);
        edtCardNumber = (EditText) findViewById(R.id.edt_card_number);
        edtCardCVC = (EditText) findViewById(R.id.edt_card_cvc);
        edtCardExpiryMonth = (EditText) findViewById(R.id.edt_card_expiry_month);
        edtCardExpiryYear = (EditText) findViewById(R.id.edt_card_expiry_year);
        payProgressBar = (ProgressBar) findViewById(R.id.payment_progress_bar);
        btnMakePayment = (Button) findViewById(R.id.btn_verify);
        btnMakePayment.setOnClickListener(this);
    }

    private void getCardData() {
        fullName = edtFullName.getText().toString().trim();
        cardNumber = edtCardNumber.getText().toString().trim();
        cardCVC = edtCardCVC.getText().toString().trim();
        cardExpiryMonth = Integer.parseInt(edtCardExpiryMonth.getText().toString().trim());
        cardExpiryYear = Integer.parseInt(edtCardExpiryYear.getText().toString().trim());
    }

    /**
     * set up toolbar
     */
    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.payment);
    }


    @Override
    public void onClick(View v) {
        getCardData();
        if (TextUtils.isEmpty(cardNumber)) {
            Toast.makeText(PaymentActivity.this, R.string.card_number_empty, Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(cardCVC)) {
            Toast.makeText(PaymentActivity.this, R.string.card_cvc_empty, Toast.LENGTH_SHORT).show();
        } else if (cardExpiryMonth == 0) {
            Toast.makeText(PaymentActivity.this, R.string.expiry_month_empty, Toast.LENGTH_SHORT).show();
        } else if (cardExpiryYear == 0) {
            Toast.makeText(PaymentActivity.this, R.string.expiry_year_empty, Toast.LENGTH_SHORT).show();
        } else {
            try {
                paymentPresenter.makePaymentValidation(cardNumber, cardExpiryMonth, cardExpiryYear, cardCVC);
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void showProgressBar() {
        payProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        payProgressBar.setVisibility(View.GONE);

    }

    @Override
    public void invalidCardDetail() {
        Toast.makeText(PaymentActivity.this, R.string.invalid_card_credentials, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToMainActivity() {
        Toast.makeText(PaymentActivity.this, R.string.payment_successfull, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(PaymentActivity.this, DashBoardActivity.class));
    }
}
