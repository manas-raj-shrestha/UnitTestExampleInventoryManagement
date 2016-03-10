package com.leapfrog.inventorymanagementsystem.views;

/**
 * Interface to fetch view from main activity for main activity presenter
 */
public interface ItemDetailView {
    int getQuantity();

    String getItemCode();

    void purchaseSuccessful();

    void purchaseFailure();

    interface UserInteractions{
        void addToCart();
    }

}
