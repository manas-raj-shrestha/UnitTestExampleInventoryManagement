
package com.leapfrog.inventorymanagementsystem.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Subscriptions {

    @SerializedName("object")
    @Expose
    public String object;
    @SerializedName("data")
    @Expose
    public List<Object> data = new ArrayList<Object>();
    @SerializedName("has_more")
    @Expose
    public boolean hasMore;
    @SerializedName("total_count")
    @Expose
    public long totalCount;
    @SerializedName("url")
    @Expose
    public String url;

}
