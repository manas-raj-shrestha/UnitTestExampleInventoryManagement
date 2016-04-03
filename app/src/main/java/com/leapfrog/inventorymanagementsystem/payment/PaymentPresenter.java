package com.leapfrog.inventorymanagementsystem.payment;

import com.stripe.exception.AuthenticationException;

/**
 * Created by sur_a on 3/31/2016.
 */
public interface PaymentPresenter {

    void makePaymentValidation(String cardNumber, int cardExpMonth, int cardExpYear, String cardCVC) throws AuthenticationException;
}