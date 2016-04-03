package com.leapfrog.inventorymanagementsystem.payment;

import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.stripe.exception.AuthenticationException;

/**
 * Created by sur_a on 4/1/2016.
 */
public class PaymentPresenterImplementation implements PaymentPresenter, onPaymentFinishListener {

    private PaymentView paymentView;
    private PaymentInteractorImplementation paymentInteractorImplementation;

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
            paymentView.invalidCardDetail();
        }

    }

    @Override
    public void onPaymentException() {

    }

    @Override
    public void makePaymentValidation(String cardNumber, int cardExpMonth, int cardExpYear, String cardCVC) throws AuthenticationException {
        if (paymentView != null) {
            paymentView.showProgressBar();
            Card card = new Card(cardNumber, cardExpMonth, cardExpYear, cardCVC);
            if (!card.validateCard()) {
                paymentView.invalidCardDetail();
            } else {
                Stripe stripe = new Stripe("pk_test_JEk3cZrIb6Pmoxdv3Y4Bbqqw");
                stripe.createToken(
                        card,
                        new TokenCallback() {
                            public void onSuccess(Token token) {
                            }
                            public void onError(Exception error) {

                            }
                        }
                );

            }
        }
    }
}
