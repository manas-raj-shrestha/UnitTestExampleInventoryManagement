package com.leapfrog.inventorymanagementsystem.payment;

import android.text.TextUtils;
import android.util.Log;

import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.stripe.exception.AuthenticationException;

/**
 * Created by sur_a on 4/1/2016.
 */
public class PaymentInteractorImplementation implements PaymentInteractor {
    @Override
    public void makePayment(String cardNumber, int cardExpMonth, int cardExpYear, String cardCVC, final onPaymentFinishListener onPaymentFinishListener) throws AuthenticationException {
        if (!TextUtils.isEmpty(cardNumber)) {
            Card card = new Card(cardNumber, cardExpMonth, cardExpYear, cardCVC);
            if (!card.validateCard()) {
                onPaymentFinishListener.onPaymentError();
            } else {
                Stripe stripe = new Stripe("pk_test_JEk3cZrIb6Pmoxdv3Y4Bbqqw");
                stripe.createToken(
                        card,
                        new TokenCallback() {
                            public void onSuccess(Token token) {
                                onPaymentFinishListener.onPaymentSuccess();
                            }

                            public void onError(Exception error) {
                                onPaymentFinishListener.onPaymentError();
                                Log.i("Payment Presenter", "onError: ");
                            }
                        }
                );

            }

        } else {
            onPaymentFinishListener.onPaymentError();
        }
    }
}
