package com.leapfrog.inventorymanagementsystem.models;

/**
 * Model class for inventory items
 */
public class Item {
    private String itemCode;
    private String itemName;
    private int itemQuantity;
    private String itemDescription;
    private long itemDateAdded;

    public Item(String itemCode,String itemName, int itemQuantity, String itemDescription, long itemDateAdded) {
        setItemCode(itemCode);
        setItemName(itemName);
        setItemQuantity(itemQuantity);
        setItemDescription(itemDescription);
        setItemDateAdded(itemDateAdded);
    }

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
}
