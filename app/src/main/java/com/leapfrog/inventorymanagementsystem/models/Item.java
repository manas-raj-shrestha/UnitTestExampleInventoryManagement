package com.leapfrog.inventorymanagementsystem.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Model class for inventory items
 */
public class Item implements Parcelable{
    private String itemCode;
    private String itemName;
    private int itemQuantity;
    private String itemDescription;
    private long itemDateAdded;
    private String picDrawableId;
    private String dealerName;
    private String price;

    public Item(String itemCode,String itemName, int itemQuantity, String itemDescription,
                String picDrawableId,long itemDateAdded,String dealerName,String price) {
        setItemCode(itemCode);
        setItemName(itemName);
        setItemQuantity(itemQuantity);
        setItemDescription(itemDescription);
        setItemDateAdded(itemDateAdded);
        setPicDrawableId(picDrawableId);
        setDealerName(dealerName);
        setPrice(price);
    }

    protected Item(Parcel in) {
        itemCode = in.readString();
        itemName = in.readString();
        itemQuantity = in.readInt();
        itemDescription = in.readString();
        itemDateAdded = in.readLong();
        picDrawableId = in.readString();
        dealerName = in.readString();
        price = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public long getItemDateAdded() {
        return itemDateAdded;
    }

    public void setItemDateAdded(long itemDateAdded) {
        this.itemDateAdded = itemDateAdded;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(itemCode);
        parcel.writeString(itemName);
        parcel.writeInt(itemQuantity);
        parcel.writeString(itemDescription);
        parcel.writeLong(itemDateAdded);
        parcel.writeString(picDrawableId);
        parcel.writeString(dealerName);
        parcel.writeString(price);
    }

    public String getPicDrawableId() {
        return picDrawableId;
    }

    public void setPicDrawableId(String picDrawableId) {
        this.picDrawableId = picDrawableId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
