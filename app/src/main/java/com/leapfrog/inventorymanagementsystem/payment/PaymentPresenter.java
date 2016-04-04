package com.leapfrog.inventorymanagementsystem.payment;

import com.stripe.exception.AuthenticationException;

/**
 * Interface definition for a callback to be invoked when payment is to validated.
 */
public interface PaymentPresenter {

    void makePaymentValidation(String cardNumber, int cardExpMonth, int cardExpYear, String cardCVC) throws AuthenticationException;
}