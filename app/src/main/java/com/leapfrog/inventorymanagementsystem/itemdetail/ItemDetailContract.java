package com.leapfrog.inventorymanagementsystem.itemdetail;

import com.leapfrog.inventorymanagementsystem.models.Item;

/**
 * Interface to fetch view from main activity for main activity presenter
 */
public interface ItemDetailContract {
    int getQuantity();

    String getItemCode();

    void purchaseSuccessful();

    void purchaseFailure();

    void showAddToCartDialog();

    interface UserInteractions{
        void addToCart(Item item);
    }

}
