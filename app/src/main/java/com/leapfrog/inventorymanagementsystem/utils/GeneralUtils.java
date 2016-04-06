package com.leapfrog.inventorymanagementsystem.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.leapfrog.inventorymanagementsystem.MisumiApplication;
import com.leapfrog.inventorymanagementsystem.models.Item;

import java.util.ArrayList;

/**
 * Methods used by app
 */
public class GeneralUtils {

    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    /**
     * This method filters the items according to item types
     *
     * @param itemArrayList array list to be sorted
     * @param itemType      filter condition
     * @return filtered list
     */
    public static ArrayList<Item> filterItems(ArrayList<Item> itemArrayList, Item.ItemType itemType) {
        ArrayList<Item> tempList = new ArrayList<>();

        for (Item item : itemArrayList) {
            if (item.getItemType().equals(itemType)) {
                tempList.add(item);
            }
        }

        return tempList;
    }

    public static String getString(int stringId) {
        return MisumiApplication.getContext().getString(stringId);
    }




}
