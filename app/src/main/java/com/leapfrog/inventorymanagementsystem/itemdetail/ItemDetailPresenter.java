package com.leapfrog.inventorymanagementsystem.itemdetail;

import android.widget.Toast;

import com.leapfrog.inventorymanagementsystem.ItemNotInStockException;
import com.leapfrog.inventorymanagementsystem.MisumiApplication;
import com.leapfrog.inventorymanagementsystem.R;
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
                Toast.makeText(MisumiApplication.getContext(), MisumiApplication.getContext().getString(R.string.txt_item_removed), Toast.LENGTH_SHORT).show();
            } else {
                cartItems.add(item.getItemCode());
                Toast.makeText(MisumiApplication.getContext(), MisumiApplication.getContext().getString(R.string.txt_item_added), Toast.LENGTH_SHORT).show();
            }
        } else {
            cartItems = new ArrayList<>();
            cartItems.add(item.getItemCode());
            Toast.makeText(MisumiApplication.getContext(), MisumiApplication.getContext().getString(R.string.txt_item_added), Toast.LENGTH_SHORT).show();
        }

        HawkUtils.setCartItems(cartItems);
    }

}
