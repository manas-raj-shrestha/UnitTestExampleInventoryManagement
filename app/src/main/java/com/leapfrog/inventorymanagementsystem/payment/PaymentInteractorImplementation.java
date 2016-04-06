package com.leapfrog.inventorymanagementsystem.payment;

import android.text.TextUtils;
import android.util.Log;

import com.leapfrog.inventorymanagementsystem.api.DataCallback;
import com.leapfrog.inventorymanagementsystem.api.EndPoints;
import com.leapfrog.inventorymanagementsystem.api.EntityInterceptor;
import com.leapfrog.inventorymanagementsystem.data.Customer;
import com.leapfrog.inventorymanagementsystem.data.HawkUtils;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.stripe.exception.AuthenticationException;

import timber.log.Timber;

/**
 * Check payment data from {@link Stripe}
 */
public class PaymentInteractorImplementation implements PaymentInteractor {
    @Override
    public void makePayment(String cardNumber, int cardExpMonth, int cardExpYear, String cardCVC, final String amount, final onPaymentFinishListener onPaymentFinishListener) throws AuthenticationException {
        if (!TextUtils.isEmpty(cardNumber)) {
            Card card = new Card(cardNumber, cardExpMonth, cardExpYear, cardCVC);
            if (!card.validateCard()) {
                onPaymentFinishListener.onPaymentError();
            } else {
                Stripe stripe = new Stripe(EndPoints.STRIPE_PUBLISHABLE_KEY);
                stripe.createToken(
                        card,
                        new TokenCallback() {
                            public void onSuccess(Token token) {

                                //onPaymentFinishListener.onPaymentSuccess();
                                if (HawkUtils.getCustomerId() == null)
                                    createCustomer(token.getId(), amount, onPaymentFinishListener);
                                else {
                                    createCharge(HawkUtils.getCustomerId(), amount, onPaymentFinishListener);
                                }


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

    private void createCustomer(String token, final String amount, final onPaymentFinishListener callback) {
        String[] params = new String[3];
        Customer customer = Customer.getValidCustomer();
        params[0] = token;
        params[1] = customer.fullName;
        params[2] = customer.email;
        EntityInterceptor.getInstance().createCustomer(new DataCallback<Customer>() {
            @Override
            public void onResponse(Customer response) {
                Timber.d("Customer Id %s", response.id);
                HawkUtils.setCustomerId(response.id);
                createCharge(response.id, amount, callback);
                //callback.onPaymentSuccess();
            }

            @Override
            public void onFailure(String error) {
                callback.onPaymentError();
            }
        }, params);
    }

    private void createCharge(String customerId, String amount, final onPaymentFinishListener callback) {
        //0 = amount
    }
}
