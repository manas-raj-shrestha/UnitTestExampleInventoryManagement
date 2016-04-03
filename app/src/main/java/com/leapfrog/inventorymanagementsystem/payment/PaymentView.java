package com.leapfrog.inventorymanagementsystem.payment;

/**
 * Created by sur_a on 3/31/2016.
 */
public interface PaymentView {

    void showProgressBar();

    void hideProgressBar();

    void invalidCardDetail();

    void navigateToMainActivity();
}
