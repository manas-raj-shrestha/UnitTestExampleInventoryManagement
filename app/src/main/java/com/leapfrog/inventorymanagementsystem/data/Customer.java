package com.leapfrog.inventorymanagementsystem.data;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.utils.GeneralUtils;

import java.io.Serializable;

/**
 * Created by laaptu on 4/6/16.
 */
public class Customer implements Serializable {
    public String fullName, cardNumber, cardCVC, expiryMonth, expiryYear, email;

    public static Customer getValidCustomer() {
        Customer customer = new Customer();
        customer.fullName = GeneralUtils.getString(R.string.card_name);
        customer.cardCVC = GeneralUtils.getString(R.string.card_cvc_valid);
        customer.cardNumber = GeneralUtils.getString(R.string.card_number_valid);
        customer.expiryMonth = GeneralUtils.getString(R.string.card_expiry_month);
        customer.expiryYear = GeneralUtils.getString(R.string.card_expiry_year);
        customer.email = GeneralUtils.getString(R.string.card_email);
        return customer;
    }
}
