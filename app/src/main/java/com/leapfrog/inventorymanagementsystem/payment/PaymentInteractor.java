package com.leapfrog.inventorymanagementsystem.payment;

import com.stripe.exception.AuthenticationException;

/**
 * Interface definition for a callback to be invoked when payment process is to be finalized.
 */
public interface PaymentInteractor {

    void makePayment(String cardNumber, int cardExpMonth, int cardExpYear, String cardCVC, onPaymentFinishListener onPaymentFinishListener) throws AuthenticationException;
}
