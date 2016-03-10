package com.leapfrog.inventorymanagementsystem.presenters;

import android.util.Log;
import android.widget.Toast;

import com.leapfrog.inventorymanagementsystem.ItemNotInStockException;
import com.leapfrog.inventorymanagementsystem.ShopflixApplication;
import com.leapfrog.inventorymanagementsystem.data.HawkUtils;
import com.leapfrog.inventorymanagementsystem.models.Inventory;
import com.leapfrog.inventorymanagementsystem.models.Item;
import com.leapfrog.inventorymanagementsystem.views.ItemDetailView;

import java.util.ArrayList;

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
    public void addToCart(Item item) {
        ArrayList<String> cartItems = HawkUtils.getCartItems();

        if (cartItems != null) {
            if (cartItems.contains(item.getItemCode())) {
                cartItems.remove(item.getItemCode());
                Toast.makeText(ShopflixApplication.getContext(), "Item removed from your cart", Toast.LENGTH_SHORT).show();
            } else {
                cartItems.add(item.getItemCode());
                Toast.makeText(ShopflixApplication.getContext(), "Item added to your cart", Toast.LENGTH_SHORT).show();
            }
        } else {
            cartItems.add(item.getItemCode());
            Toast.makeText(ShopflixApplication.getContext(), "Item added to your cart", Toast.LENGTH_SHORT).show();
        }

        HawkUtils.setCartItems(cartItems);


        Log.e("added to card", "added to cart " + item.getItemCode());
    }
}
