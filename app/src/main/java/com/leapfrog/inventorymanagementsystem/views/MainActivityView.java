package com.leapfrog.inventorymanagementsystem.views;

/**
 * Interface to fetch view from main activity for main activity presenter
 */
public interface MainActivityView {
    int getQuantity();

    String getItemCode();

    void purchaseSuccessful();

    void purchaseFailure();

}
