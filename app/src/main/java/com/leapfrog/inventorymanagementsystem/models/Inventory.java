package com.leapfrog.inventorymanagementsystem.models;

import android.util.Log;

import com.leapfrog.inventorymanagementsystem.ItemNotInStockException;
import com.leapfrog.inventorymanagementsystem.MisumiApplication;
import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.data.HawkUtils;
import com.leapfrog.inventorymanagementsystem.settings.SettingsActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Repository for items
 * Creates dummy items
 */
public class Inventory implements InventoryActions {
    private static Inventory inventory;
    public static ArrayList<Item> items = new ArrayList<>();
    private HashMap<String, Integer> hashMap = new HashMap<>();

    public static Inventory getInstance() {
        if (inventory == null)
            inventory = new Inventory();

        return inventory;
    }

    public void loadInventory() {
        createDrawableMap();
        try {
            JSONArray m_jArry = new JSONArray(loadJSONFromAsset());

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                Log.d("Details-->", jo_inside.getString("itemCode"));
//                String formula_value = jo_inside.getString("formule");
//                String url_value = jo_inside.getString("url");

                Item item = new Item();
                item.setItemCode(jo_inside.getString("itemCode"));
                item.setItemName(jo_inside.getString("itemName"));
                item.setItemQuantity(jo_inside.getInt("itemQuantity"));
                item.setItemDescription(jo_inside.getString("itemDescription"));
                item.setDealerName(jo_inside.getString("dealerName"));
                item.setPrice(jo_inside.getInt("price"));
                item.setItemType(Item.ItemType.valueOf(jo_inside.getString("itemType")));
                item.setPicDrawableId(hashMap.get(item.getItemCode()));
                items.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private Inventory() {
//        addWireItems();
//        addControlItems();
//        addKnifeAndTools();

        loadInventory();
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = null;
            if (HawkUtils.getLanguage().equals(SettingsActivity.Language.CHINESE)) {
                is = MisumiApplication.getContext().getAssets().open("json_cn.txt");
            } else {
                is = MisumiApplication.getContext().getAssets().open("json_en.txt");
            }

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
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
        items.add(new Item("FX3U", "MELSEC-F FX3U Series main unit", 10,
                "And with more ease and flexibility of a scalable, it will ease the FX3 to control 128 * 1 The following are suitable for small-scale control of the excellent value for money.",
                R.drawable.fx3u,
                Calendar.getInstance().getTimeInMillis(), "MITSUBISHI", 15000, Item.ItemType.CONTROL));
        items.add(new Item("FX3G", "MELSEC-F FX3G Series main unit", 100,
                "Along with the ease-one and flexible scalability, excellent value for money for small-scale control.",
                R.drawable.fx3g,
                Calendar.getInstance().getTimeInMillis(), "MITSUBISHI", 50000, Item.ItemType.CONTROL));
        items.add(new Item("S7", "S7-200 central processing unit (CPU)",
                100, "The modular micro PLC system to meet the performance requirements of small-scale, can be very good to meet and adapt to automation control tasks, simple and practical distributed architecture and multi-interface network capability makes the application very flexible.",
                R.drawable.s7,
                Calendar.getInstance().getTimeInMillis(), "Seimens", 15000, Item.ItemType.CONTROL));
        items.add(new Item("S73", "S7-300 central processing unit (CPU)",
                100, "The modular micro PLC system to meet the performance requirements of small-scale, can be very good to meet and adapt to automation control tasks, simple and practical distributed architecture and multi-interface network capability makes the application very flexible.",
                R.drawable.s73,
                Calendar.getInstance().getTimeInMillis(), "Seimens", 15000, Item.ItemType.CONTROL));
        items.add(new Item("qnu1", "QnU series CPU module",
                100, "QnU series CPU module", R.drawable.qnu1,
                Calendar.getInstance().getTimeInMillis(), "MITSUBISHI", 15000, Item.ItemType.CONTROL));
    }

    /**
     * create wire items
     */
    private void addWireItems() {
        items.add(new Item("UC1", "Universal coax C / D / RG type", 100, "Universal coax C / D / RG type",
                R.drawable.uc1,
                Calendar.getInstance().getTimeInMillis(), "MISUMI", 2, Item.ItemType.WIRE));
        items.add(new Item("SYV1", "Polyethylene insulated RF coaxial cable SYV", 100,
                "Polyethylene insulated RF coaxial cable SYV", R.drawable.syv1,
                Calendar.getInstance().getTimeInMillis(), "MISUMI", 1, Item.ItemType.WIRE));
        items.add(new Item("CC1", "Coaxial Cable", 1,
                "Coaxial Cable", R.drawable.cc1,
                Calendar.getInstance().getTimeInMillis(), "BELDEN USA", 50, Item.ItemType.WIRE));
        items.add(new Item("NACC1", "NACC-UL standard CC-Link cable", 100,
                "NACC-UL standard CC-Link cable",
                R.drawable.nacc1, Calendar.getInstance().getTimeInMillis(),
                "MISUMI", 4, Item.ItemType.WIRE));
        items.add(new Item("CAT51", "CAT.5ELAN", 100,
                "High bending CAT.5ELAN cable",
                R.drawable.cat51,
                Calendar.getInstance().getTimeInMillis(), "Japan Oki Electric Cable (OKI)", 6, Item.ItemType.WIRE));
        items.add(new Item("DNC1", "Device-Net cable", 100,
                "Fixed portion / low-speed movable -UL Specifications -Device-Net cable",
                R.drawable.dnc1,
                Calendar.getInstance().getTimeInMillis(), "MISUMI", 6, Item.ItemType.WIRE));
    }

    public void createDrawableMap() {
        hashMap.put("UC1", R.drawable.uc1);
        hashMap.put("SYV1", R.drawable.syv1);
        hashMap.put("CC1", R.drawable.cc1);
        hashMap.put("NACC1", R.drawable.nacc1);
        hashMap.put("CAT51", R.drawable.cat51);
        hashMap.put("DNC1", R.drawable.dnc1);

        hashMap.put("FX3U", R.drawable.fx3u);
        hashMap.put("FX3G", R.drawable.fx3g);
        hashMap.put("S7", R.drawable.s7);
        hashMap.put("S73", R.drawable.s73);
        hashMap.put("qnu1", R.drawable.qnu1);

        hashMap.put("OK50H", R.drawable.ok50h);
        hashMap.put("OK35SQ", R.drawable.ok35sq);
        hashMap.put("CX500", R.drawable.cx500);
        hashMap.put("BEM1", R.drawable.bem1);
        hashMap.put("FKD1", R.drawable.fkd1);
        hashMap.put("QEFD", R.drawable.qefd);
    }

}
