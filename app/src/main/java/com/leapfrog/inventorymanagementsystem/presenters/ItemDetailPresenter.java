package com.leapfrog.inventorymanagementsystem.presenters;

import android.util.Log;

import com.leapfrog.inventorymanagementsystem.ItemNotInStockException;
import com.leapfrog.inventorymanagementsystem.models.Inventory;
import com.leapfrog.inventorymanagementsystem.views.ItemDetailView;

/**
 * Presenter for item detail activity
 */
public class ItemDetailPresenter implements ItemDetailView.UserInteractions {
    ItemDetailView itemDetailView;
    Inventory inventory;

    public ItemDetailPresenter(ItemDetailView itemDetailView) {
        this.itemDetailView = itemDetailView;
        inventory = Inventory.getInstance();
    }

    public void buyItems() {
        try {
            inventory.purchaseItems(itemDetailView.getItemCode(), itemDetailView.getQuantity());
            itemDetailView.purchaseSuccessful();
        } catch (ItemNotInStockException e) {
            itemDetailView.purchaseFailure();
        }
    }

    @Override
    public void addToCart() {
        Log.e("added to card", "added to cart");
    }
}
