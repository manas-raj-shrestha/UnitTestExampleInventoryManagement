package com.leapfrog.inventorymanagementsystem.payment;

import android.text.TextUtils;

/**
 * Created by sur_a on 4/1/2016.
 */
public class PaymentInteractorImplementation implements PaymentInteractor{
    @Override
    public void makePayment(String cardNumber, String cardExpMonth, String cardExpYear, String cardCVC, onPaymentFinishListener onPaymentFinishListener) {
        if(!TextUtils.isEmpty(cardNumber)){
            onPaymentFinishListener.onPaymentSuccess();
        }else{
            onPaymentFinishListener.onPaymentError();
        }
    }
}
