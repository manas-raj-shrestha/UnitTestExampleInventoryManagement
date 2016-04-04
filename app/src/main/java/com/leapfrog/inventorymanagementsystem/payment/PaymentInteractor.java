package com.leapfrog.inventorymanagementsystem.payment;

import com.stripe.exception.AuthenticationException;

/**
 * Created by sur_a on 3/31/2016.
 */
public interface PaymentInteractor {

    void makePayment(String cardNumber, int cardExpMonth, int cardExpYear, String cardCVC, onPaymentFinishListener onPaymentFinishListener) throws AuthenticationException;
}
