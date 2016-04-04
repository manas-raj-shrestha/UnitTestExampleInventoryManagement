package com.leapfrog.inventorymanagementsystem.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Model class for inventory items
 */
public class Item implements Parcelable {
    private String itemCode;
    private String itemName;
    private int itemQuantity;
    private String itemDescription;
    private long itemDateAdded;
    private int picDrawableId;
    private String dealerName;
    private int price;
    private ItemType itemType;

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public enum ItemType {
        WIRE,
        CONTROL,
        itemType, KNIFE_AND_TOOLS
    }

    public Item(){

    }

    public Item(String itemCode, String itemName, int itemQuantity, String itemDescription,
                int picDrawableId, long itemDateAdded, String dealerName, int price,ItemType itemType) {
        setItemCode(itemCode);
        setItemName(itemName);
        setItemQuantity(itemQuantity);
        setItemDescription(itemDescription);
        setItemDateAdded(itemDateAdded);
        setPicDrawableId(picDrawableId);
        setDealerName(dealerName);
        setPrice(price);
        setItemType(itemType);
    }

    protected Item(Parcel in) {
        itemCode = in.readString();
        itemName = in.readString();
        itemQuantity = in.readInt();
        itemDescription = in.readString();
        itemDateAdded = in.readLong();
        picDrawableId = in.readInt();
        dealerName = in.readString();
        price = in.readInt();
        itemType = ItemType.valueOf(in.readString());
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
        parcel.writeInt(picDrawableId);
        parcel.writeString(dealerName);
        parcel.writeInt(price);
        parcel.writeString(itemType.name());
    }

    public int getPicDrawableId() {
        return picDrawableId;
    }

    public void setPicDrawableId(int picDrawableId) {
        this.picDrawableId = picDrawableId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
