package com.leapfrog.inventorymanagementsystem.models;

import com.leapfrog.inventorymanagementsystem.ItemNotInStockException;

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
        items.add(new Item("RAYBAN004", "Ray ban Wayfarer", 100, "Rayban Wayfarer", "http://www.ray-ban.com/_repository/_resources/_images/og/cat_wayfarer.jpg", Calendar.getInstance().getTimeInMillis(), "Ray ban", 250));
        items.add(new Item("VERSACE567", "Versace Jeans", 100, "Blue Jeans", "http://images.idreampolo.ru/201505/s-157238/versace-jeans-for-men-157238.jpg", Calendar.getInstance().getTimeInMillis(), "Versace", 150));
        items.add(new Item("JOCKEY435", "Jockey Multicolored Socks", 100, "APPLE IMAC21.5' 1.4GHZ DUAL CORE/2X4GB/500GB", "http://n2.sdlcdn.com/imgs/a/3/z/198x232/Jockey-Casual-Ankle-Length-Socks-SDL288448409-1-0c8de.jpg", Calendar.getInstance().getTimeInMillis(), "Jockey", 50));
        items.add(new Item("NIKE324", "Nike Shoes", 100, "Nike Downshifter 6 Men's Running Shoes - Men Sneakers", "http://i.ebayimg.com/images/i/271723310731-0-1/s-l1000.jpg", Calendar.getInstance().getTimeInMillis(), "Nike", 400));
        items.add(new Item("NIKE123", "Nike Air Jordan 4 IV", 100, "Nike Air Jordan 4 IV Alternate 89 2016 Basketball Sneaker Shoes All Size QS", "http://i.ebayimg.com/images/m/mCQAhbdaBc_5sQKyI2_WHUg/s-l225/p.jpg", Calendar.getInstance().getTimeInMillis(), "Nike", 600));
        items.add(new Item("BG123", "Wallet Handbag Clutch Bag", 100, "Wallet Handbag Clutch Bag", "https://s-media-cache-ak0.pinimg.com/236x/64/86/fd/6486fd7fb5361355d1f9b9874e3de36c.jpg", Calendar.getInstance().getTimeInMillis(), "BG", 150));
        items.add(new Item("BCBG123", "BCBG PIPER black off white peplum dress", 100, "BCBG PIPER black off white peplum dress", "http://i.ebayimg.com/images/g/wPMAAOSwyZ5UnQye/s-l300.jpg", Calendar.getInstance().getTimeInMillis(), "BCBG", 500));
        items.add(new Item("MOCHAELKORS123", "MICHAEL KORS Women's Watch Runway Gold Tone Pink Dial", 100, "MICHAEL KORS Women's Watch Runway Gold Tone Pink Dial", "http://thumbs3.ebaystatic.com/d/l225/m/m1XOHO_SFRLoZWFnYljFwsg.jpg", Calendar.getInstance().getTimeInMillis(), "MK", 150));
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
