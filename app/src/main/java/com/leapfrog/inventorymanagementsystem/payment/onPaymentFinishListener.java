package com.leapfrog.inventorymanagementsystem.payment;

/**
 * Created by sur_a on 3/31/2016.
 */
public interface onPaymentFinishListener {

    void onPaymentSuccess();


    void onPaymentError();

    void onPaymentException();
}
