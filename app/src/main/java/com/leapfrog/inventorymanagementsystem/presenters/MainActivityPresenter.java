package com.leapfrog.inventorymanagementsystem.presenters;

import com.leapfrog.inventorymanagementsystem.ItemNotInStockException;
import com.leapfrog.inventorymanagementsystem.models.Inventory;
import com.leapfrog.inventorymanagementsystem.views.MainActivityView;

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

    public void checkStub(String s){

    }

}
