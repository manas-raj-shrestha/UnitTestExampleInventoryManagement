package com.leapfrog.inventorymanagementsystem;

import com.leapfrog.inventorymanagementsystem.models.Inventory;

/**
 * Presenter for main activity
 */
public class MainActivityPresenter {
    MainActivityView mainActivityView;
    Inventory inventory;

    public MainActivityPresenter(MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
        inventory = Inventory.getInstance();
    }

    public void buyItems() {
        try {
            inventory.purchaseItems(mainActivityView.getItemCode(), mainActivityView.getQuantity());
            mainActivityView.purchaseSuccessful();
        } catch (ItemNotInStockException e) {
            mainActivityView.purchaseFailure();
        }
    }

}
