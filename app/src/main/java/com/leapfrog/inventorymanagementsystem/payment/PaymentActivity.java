package com.leapfrog.inventorymanagementsystem.payment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.dashboard.DashBoardActivity;
import com.leapfrog.inventorymanagementsystem.data.Customer;
import com.stripe.exception.AuthenticationException;

public class PaymentActivity extends AppCompatActivity implements PaymentView, View.OnClickListener {

    private EditText edtFullName, edtCardNumber, edtCardCVC, edtCardExpiryMonth, edtCardExpiryYear;

    private Button btnMakePayment;

    private ProgressBar payProgressBar;

    private String fullName, cardNumber, cardCVC;
    private int cardExpiryMonth, cardExpiryYear;

    private PaymentPresenter paymentPresenter;

    private Toolbar toolbar;
    private String price = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int payment = getIntent().getIntExtra(PAYMENT, PAYMENT_STRIPE);
        price = getIntent().getStringExtra(PRICE);
        getSupportActionBar().setIcon(payment == PAYMENT_STRIPE ? R.drawable.ic_stripe_logo : R.drawable.ic_wepay_logo);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //setToolbar();

        paymentPresenter = new PaymentPresenterImplementation(this);

        initViews();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
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


        Customer customer = Customer.getValidCustomer();
        edtFullName.setText(customer.fullName);
        edtCardNumber.setText(customer.cardNumber);
        edtCardCVC.setText(customer.cardCVC);
        edtCardExpiryMonth.setText(customer.expiryMonth);
        edtCardExpiryYear.setText(customer.expiryYear);
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
                long mainPrice = Long.valueOf(price);
                if (mainPrice / 1000 < 1) {
                    mainPrice += (1000 - mainPrice);
                    price = String.valueOf(mainPrice);
                }
                paymentPresenter.makePaymentValidation(cardNumber, cardExpiryMonth, cardExpiryYear, cardCVC, price);
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
        Intent intent = new Intent(PaymentActivity.this, DashBoardActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }


    public static final int PAYMENT_STRIPE = 0x1, PAYMENT_WEPAY = 0x2;
    private static final String PAYMENT = "payment", PRICE = "price";

    public static Intent launchActivity(Context context, int payment, String price) {
        Intent intent = new Intent(context, PaymentActivity.class);
        intent.putExtra(PAYMENT, payment);
        intent.putExtra(PRICE, price);
        return intent;
    }
}
