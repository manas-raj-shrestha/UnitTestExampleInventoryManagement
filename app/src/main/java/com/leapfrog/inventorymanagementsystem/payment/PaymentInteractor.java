package com.leapfrog.inventorymanagementsystem.payment;

/**
 * Created by sur_a on 3/31/2016.
 */
public interface PaymentInteractor {

    void makePayment(String cardNumber, String cardExpMonth, String cardExpYear, String cardCVC, onPaymentFinishListener onPaymentFinishListener);
}
