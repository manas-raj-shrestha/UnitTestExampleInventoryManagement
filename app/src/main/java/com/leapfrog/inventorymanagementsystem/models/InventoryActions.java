package com.leapfrog.inventorymanagementsystem.models;

import com.leapfrog.inventorymanagementsystem.ItemNotInStockException;

/**
 * Contract for inventory
 */
public interface InventoryActions {
    void purchaseItems(String itemId, int itemQuantity) throws ItemNotInStockException;

    void addItems(String itemId, String itemName, int itemQuantity, String itemDescription, long dateAdded) throws ItemNotInStockException;
}
