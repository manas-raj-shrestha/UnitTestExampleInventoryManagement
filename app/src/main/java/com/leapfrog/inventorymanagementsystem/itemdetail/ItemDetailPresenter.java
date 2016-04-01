package com.leapfrog.inventorymanagementsystem.itemdetail;

import android.util.Log;
import android.widget.Toast;

import com.leapfrog.inventorymanagementsystem.ItemNotInStockException;
import com.leapfrog.inventorymanagementsystem.MisumiApplication;
import com.leapfrog.inventorymanagementsystem.data.HawkUtils;
import com.leapfrog.inventorymanagementsystem.models.Inventory;
import com.leapfrog.inventorymanagementsystem.models.Item;

import java.util.ArrayList;

/**
 * Presenter for item detail activity
 */
public class ItemDetailPresenter implements ItemDetailContract.UserInteractions {
    ItemDetailContract itemDetailContract;
    Inventory inventory;

    public ItemDetailPresenter(ItemDetailContract itemDetailContract) {
        this.itemDetailContract = itemDetailContract;
        inventory = Inventory.getInstance();
    }

    public void buyItems() {
        try {
            inventory.purchaseItems(itemDetailContract.getItemCode(), itemDetailContract.getQuantity());
            itemDetailContract.purchaseSuccessful();
        } catch (ItemNotInStockException e) {
            itemDetailContract.purchaseFailure();
        }
    }

    @Override
    public void addToCart(Item item) {
        ArrayList<String> cartItems = HawkUtils.getCartItems();

        if (cartItems != null) {
            if (cartItems.contains(item.getItemCode())) {
                cartItems.remove(item.getItemCode());
                Toast.makeText(MisumiApplication.getContext(), "Item removed from your cart", Toast.LENGTH_SHORT).show();
            } else {
                cartItems.add(item.getItemCode());
                Toast.makeText(MisumiApplication.getContext(), "Item added to your cart", Toast.LENGTH_SHORT).show();
            }
        } else {
            cartItems = new ArrayList<>();
            cartItems.add(item.getItemCode());
            Toast.makeText(MisumiApplication.getContext(), "Item added to your cart", Toast.LENGTH_SHORT).show();
        }

        HawkUtils.setCartItems(cartItems);


        Log.e("added to card", "added to cart " + item.getItemCode());

//        itemDetailContract.showAddToCartDialog();
    }

}
