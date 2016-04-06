
package com.leapfrog.inventorymanagementsystem.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Charge {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("object")
    @Expose
    public String object;
    @SerializedName("amount")
    @Expose
    public long amount;
    @SerializedName("amount_refunded")
    @Expose
    public long amountRefunded;
    @SerializedName("application_fee")
    @Expose
    public Object applicationFee;
    @SerializedName("balance_transaction")
    @Expose
    public String balanceTransaction;
    @SerializedName("captured")
    @Expose
    public boolean captured;
    @SerializedName("created")
    @Expose
    public long created;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("customer")
    @Expose
    public String customer;
    @SerializedName("description")
    @Expose
    public Object description;
    @SerializedName("destination")
    @Expose
    public Object destination;
    @SerializedName("dispute")
    @Expose
    public Object dispute;
    @SerializedName("failure_code")
    @Expose
    public Object failureCode;
    @SerializedName("failure_message")
    @Expose
    public Object failureMessage;
    @SerializedName("fraud_details")
    @Expose
    public FraudDetails fraudDetails;
    @SerializedName("invoice")
    @Expose
    public Object invoice;
    @SerializedName("livemode")
    @Expose
    public boolean livemode;
    @SerializedName("metadata")
    @Expose
    public Metadata metadata;
    @SerializedName("order")
    @Expose
    public Object order;
    @SerializedName("paid")
    @Expose
    public boolean paid;
    @SerializedName("receipt_email")
    @Expose
    public Object receiptEmail;
    @SerializedName("receipt_number")
    @Expose
    public Object receiptNumber;
    @SerializedName("refunded")
    @Expose
    public boolean refunded;
    @SerializedName("refunds")
    @Expose
    public Refunds refunds;
    @SerializedName("shipping")
    @Expose
    public Object shipping;
    @SerializedName("source")
    @Expose
    public Source source;
    @SerializedName("source_transfer")
    @Expose
    public Object sourceTransfer;
    @SerializedName("statement_descriptor")
    @Expose
    public Object statementDescriptor;
    @SerializedName("status")
    @Expose
    public String status;

}
