package com.leapfrog.inventorymanagementsystem.payment;

/**
 * Interface definition for a callback to be invoked when view is handled according to payment steps
 */
public interface PaymentView {

    void showProgressBar();

    void hideProgressBar();

    void invalidCardDetail();

    void navigateToMainActivity();
}
