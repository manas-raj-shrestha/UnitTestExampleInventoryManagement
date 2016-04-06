
package com.leapfrog.inventorymanagementsystem.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("object")
    @Expose
    public String object;
    @SerializedName("address_city")
    @Expose
    public Object addressCity;
    @SerializedName("address_country")
    @Expose
    public Object addressCountry;
    @SerializedName("address_line1")
    @Expose
    public Object addressLine1;
    @SerializedName("address_line1_check")
    @Expose
    public Object addressLine1Check;
    @SerializedName("address_line2")
    @Expose
    public Object addressLine2;
    @SerializedName("address_state")
    @Expose
    public Object addressState;
    @SerializedName("address_zip")
    @Expose
    public Object addressZip;
    @SerializedName("address_zip_check")
    @Expose
    public Object addressZipCheck;
    @SerializedName("brand")
    @Expose
    public String brand;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("customer")
    @Expose
    public String customer;
    @SerializedName("cvc_check")
    @Expose
    public String cvcCheck;
    @SerializedName("dynamic_last4")
    @Expose
    public Object dynamicLast4;
    @SerializedName("exp_month")
    @Expose
    public long expMonth;
    @SerializedName("exp_year")
    @Expose
    public long expYear;
    @SerializedName("fingerprint")
    @Expose
    public String fingerprint;
    @SerializedName("funding")
    @Expose
    public String funding;
    @SerializedName("last4")
    @Expose
    public String last4;
    @SerializedName("metadata")
    @Expose
    public Metadata metadata;
    @SerializedName("name")
    @Expose
    public Object name;
    @SerializedName("tokenization_method")
    @Expose
    public Object tokenizationMethod;

}
