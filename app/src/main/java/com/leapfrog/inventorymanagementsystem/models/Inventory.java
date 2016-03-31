package com.leapfrog.inventorymanagementsystem.models;

import com.leapfrog.inventorymanagementsystem.ItemNotInStockException;
import com.leapfrog.inventorymanagementsystem.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Repository for items
 * Creates dummy items
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
        addWireItems();
        addControlItems();
        addKnifeAndTools();
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

    /**
     * create knife and tools category tools
     */
    private void addKnifeAndTools() {
        items.add(new Item("OK50H", "50H hole cutter", 100,
                "50H hole cutter",
                R.drawable.ok50h,
                Calendar.getInstance().getTimeInMillis(), "OMI Kogyo", 150, Item.ItemType.KNIFE_AND_TOOLS));
        items.add(new Item("OK35SQ", "35SQ hole cutter", 100,
                "35SQ hole cutter", R.drawable.ok35sq,
                Calendar.getInstance().getTimeInMillis(), "OMI Kogyo", 150, Item.ItemType.KNIFE_AND_TOOLS));
        items.add(new Item("CX500", "High hardness steel blade with 2 ball end mill coating CX500", 100,
                "Increase the service life, suitable for high-speed machining and dry machining. Ideal for high-precision three-dimensional processing. Processed surface roughness is good.", R.drawable.cx500,
                Calendar.getInstance().getTimeInMillis(), "CKK", 150, Item.ItemType.KNIFE_AND_TOOLS));
        items.add(new Item("BEM1", "BEM edged carbide ball end mill", 100,
                "BEM edged carbide ball end mill", R.drawable.bem1,
                Calendar.getInstance().getTimeInMillis(), "AST", 150, Item.ItemType.KNIFE_AND_TOOLS));
        items.add(new Item("FKD1", "Side cutter (common edge)", 100,
                "And the outer peripheral side has a cutting edge, is widely used in the processing tank, stepped surface machining, side machining, width determination and so on.", R.drawable.fkd1,
                Calendar.getInstance().getTimeInMillis(), "FKD", 150, Item.ItemType.KNIFE_AND_TOOLS));
        items.add(new Item("QEFD", "Cylindrical cutting / grooving turning tool QEFD", 100,
                "Simple and compact structure, beautiful", R.drawable.qefd,
                Calendar.getInstance().getTimeInMillis(), "Zhuzhou China", 150, Item.ItemType.KNIFE_AND_TOOLS));

    }

    /**
     * create control items
     */
    private void addControlItems() {
        items.add(new Item("FX3U", "MELSEC-F FX3U Series main unit", 100,
                "And with more ease and flexibility of a scalable, it will ease the FX3 to control 128 * 1 The following are suitable for small-scale control of the excellent value for money.",
                R.drawable.fx3u,
                Calendar.getInstance().getTimeInMillis(), "MITSUBISHI", 150, Item.ItemType.CONTROL));
        items.add(new Item("FX3G", "MELSEC-F FX3G Series main unit", 100,
                "Along with the ease-one and flexible scalability, excellent value for money for small-scale control.",
                R.drawable.fx3g,
                Calendar.getInstance().getTimeInMillis(), "MITSUBISHI", 500, Item.ItemType.CONTROL));
        items.add(new Item("S7", "S7-200 central processing unit (CPU)",
                100, "The modular micro PLC system to meet the performance requirements of small-scale, can be very good to meet and adapt to automation control tasks, simple and practical distributed architecture and multi-interface network capability makes the application very flexible.",
                R.drawable.s7,
                Calendar.getInstance().getTimeInMillis(), "Seimens", 150, Item.ItemType.CONTROL));
        items.add(new Item("S73", "S7-300 central processing unit (CPU)",
                100, "The modular micro PLC system to meet the performance requirements of small-scale, can be very good to meet and adapt to automation control tasks, simple and practical distributed architecture and multi-interface network capability makes the application very flexible.",
                R.drawable.s73,
                Calendar.getInstance().getTimeInMillis(), "Seimens", 150, Item.ItemType.CONTROL));
        items.add(new Item("S7", "QnU series CPU module",
                100, "QnU series CPU module", R.drawable.qnu1,
                Calendar.getInstance().getTimeInMillis(), "MITSUBISHI", 150, Item.ItemType.CONTROL));
    }

    /**
     * create wire items
     */
    private void addWireItems() {
        items.add(new Item("UC1", "Universal coax C / D / RG type", 100, "Universal coax C / D / RG type",
                R.drawable.uc1,
                Calendar.getInstance().getTimeInMillis(), "MISUMI", 250, Item.ItemType.WIRE));
        items.add(new Item("SYV1", "Polyethylene insulated RF coaxial cable SYV", 100,
                "Polyethylene insulated RF coaxial cable SYV", R.drawable.syv1,
                Calendar.getInstance().getTimeInMillis(), "MISUMI", 150, Item.ItemType.WIRE));
        items.add(new Item("CC1", "Coaxial Cable", 100,
                "Coaxial Cable", R.drawable.cc1,
                Calendar.getInstance().getTimeInMillis(), "BELDEN USA", 50, Item.ItemType.WIRE));
        items.add(new Item("NACC1", "NACC-UL standard CC-Link cable", 100,
                "NACC-UL standard CC-Link cable",
                R.drawable.nacc1, Calendar.getInstance().getTimeInMillis(),
                "MISUMI", 400, Item.ItemType.WIRE));
        items.add(new Item("CAT51", "CAT.5ELAN", 100,
                "High bending CAT.5ELAN cable",
                R.drawable.cat51,
                Calendar.getInstance().getTimeInMillis(), "Japan Oki Electric Cable (OKI)", 600, Item.ItemType.WIRE));
        items.add(new Item("DNC1", "Device-Net cable", 100,
                "Fixed portion / low-speed movable -UL Specifications -Device-Net cable",
                R.drawable.dnc1,
                Calendar.getInstance().getTimeInMillis(), "MISUMI", 600, Item.ItemType.WIRE));
    }

}
