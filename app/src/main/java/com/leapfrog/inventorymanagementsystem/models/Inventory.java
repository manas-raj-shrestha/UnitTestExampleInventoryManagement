package com.leapfrog.inventorymanagementsystem.models;

import com.leapfrog.inventorymanagementsystem.ItemNotInStockException;
import com.leapfrog.inventorymanagementsystem.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Manas on 1/28/2016.
 */
public class Inventory implements InventoryActions {
    private static Inventory inventory;
    public static ArrayList<Item> items = new ArrayList<>();

    public static Inventory getInstance() {
        if (inventory == null)
            inventory = new Inventory();

        return inventory;
    }

    private Inventory() {
        items.add(new Item("MB13", "Mac book pro 13", 100, "13-inch: 2.5GHz dual-core Intel Core i5", R.drawable.macbook13, Calendar.getInstance().getTimeInMillis()));
        items.add(new Item("MB15", "Mac book pro 15", 100, "APPLE MACBOOK PRO RETINA 15.4/2.2GHZ/16GB/256GB ", R.drawable.macbook15, Calendar.getInstance().getTimeInMillis()));
        items.add(new Item("IM21", "IMAC 21", 100, "APPLE IMAC21.5' 1.4GHZ DUAL CORE/2X4GB/500GB", R.drawable.imac21, Calendar.getInstance().getTimeInMillis()));
        items.add(new Item("IM27", "IMAC 27", 100, "APPLE IMAC 27 3.2QC/2X4GB/1TB/GT755M", R.drawable.imac27, Calendar.getInstance().getTimeInMillis()));
        items.add(new Item("IPAD4", "APPLE IPAD MINI 4", 100, "APPLE IPAD MINI 4 WI-FI 16GB", R.drawable.ipad4, Calendar.getInstance().getTimeInMillis()));
        items.add(new Item("IPAD5", "APPLE IPAD MINI 5", 100, "APPLE IPAD MINI 5 WI-FI 16GB", R.drawable.ipad5, Calendar.getInstance().getTimeInMillis()));
    }

    @Override
    public void purchaseItems(String itemId, int itemQuantity) throws ItemNotInStockException {
        Boolean itemFound = false;
        for (Item item : items) {
            if (item.getItemCode().trim().equalsIgnoreCase(itemId) && item.getItemQuantity() >= itemQuantity) {
                item.setItemQuantity(item.getItemQuantity() - itemQuantity);
                itemFound = true;
            }
        }

        if (!itemFound) {
            throw (new ItemNotInStockException());
        }
    }


    @Override
    public void addItems(String itemId, String itemName, int itemQuantity, String itemDescription, long dateAdded) throws ItemNotInStockException {
        Boolean itemFound = false;
        for (Item item : items) {
            if (item.getItemCode().contentEquals(itemId)) {
                item.setItemQuantity(item.getItemQuantity() + itemQuantity);
            }
        }

        if (!itemFound) {
            throw (new ItemNotInStockException());
        }
    }
}
