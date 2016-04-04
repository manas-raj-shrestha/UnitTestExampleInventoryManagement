package com.leapfrog.inventorymanagementsystem.payment;

import com.stripe.exception.AuthenticationException;

public class PaymentPresenterImplementation implements PaymentPresenter, onPaymentFinishListener {

    private PaymentView paymentView;
    private PaymentInteractor paymentInteractorImplementation;

    public PaymentPresenterImplementation(PaymentView paymentView) {
        this.paymentView = paymentView;
        this.paymentInteractorImplementation = new PaymentInteractorImplementation();
    }

    @Override
    public void onPaymentSuccess() {
        if (paymentView != null) {
            paymentView.hideProgressBar();
            paymentView.navigateToMainActivity();
        }

    }

    @Override
    public void onPaymentError() {
        if (paymentView != null) {
            paymentView.hideProgressBar();
            paymentView.invalidCardDetail();
        }
    }

    @Override
    public void onPaymentException() {
        if (paymentView != null) {
            paymentView.hideProgressBar();
            paymentView.invalidCardDetail();
        }
    }

    @Override
    public void makePaymentValidation(String cardNumber, int cardExpMonth, int cardExpYear, String cardCVC) throws AuthenticationException {
        if (paymentView != null) {
            paymentView.showProgressBar();
            paymentInteractorImplementation.makePayment(cardNumber, cardExpMonth, cardExpYear, cardCVC, this);
        }
    }
}
