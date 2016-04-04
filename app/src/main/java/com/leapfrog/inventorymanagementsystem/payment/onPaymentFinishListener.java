package com.leapfrog.inventorymanagementsystem.payment;

/**
 * Interface definition for a callback to be invoked when Payment process is made
 */
public interface onPaymentFinishListener {

    void onPaymentSuccess();


    void onPaymentError();

    void onPaymentException();
}
