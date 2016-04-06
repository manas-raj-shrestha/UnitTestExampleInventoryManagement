
package com.leapfrog.inventorymanagementsystem.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.utils.GeneralUtils;

public class Customer {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("object")
    @Expose
    public String object;
    @SerializedName("account_balance")
    @Expose
    public long accountBalance;
    @SerializedName("created")
    @Expose
    public long created;
    @SerializedName("currency")
    @Expose
    public Object currency;
    @SerializedName("default_source")
    @Expose
    public String defaultSource;
    @SerializedName("delinquent")
    @Expose
    public boolean delinquent;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("discount")
    @Expose
    public Object discount;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("livemode")
    @Expose
    public boolean livemode;
    @SerializedName("metadata")
    @Expose
    public Metadata metadata;
    @SerializedName("shipping")
    @Expose
    public Object shipping;
    @SerializedName("sources")
    @Expose
    public Sources sources;
    @SerializedName("subscriptions")
    @Expose
    public Subscriptions subscriptions;
    public String fullName, cardNumber, cardCVC, expiryMonth, expiryYear, token;

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