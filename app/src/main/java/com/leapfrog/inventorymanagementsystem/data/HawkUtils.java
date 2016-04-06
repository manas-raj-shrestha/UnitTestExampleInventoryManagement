package com.leapfrog.inventorymanagementsystem.data;

import com.leapfrog.inventorymanagementsystem.settings.SettingsActivity;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;

/**
 * Shared preference handler/manager for app using Hawk utils
 */
public class HawkUtils {
    private static final String KEY_LOGIN_STATUS = "login_status";
    private static final String KEY_CART_ITEMS = "cart_items";
    private static final String KEY_FAVORITE_ITEMS = "fav_items";
    private static final String KEY_LANGUAGE = "language";
    //right now we are only using a single customer id
    private static final String CUSTOMER_ID = "customerId";

    public static void setLoginStatus(boolean loginStatus) {
        Hawk.put(KEY_LOGIN_STATUS, loginStatus);
    }

    public static boolean getLoginStatus() {
        return Hawk.get(KEY_LOGIN_STATUS, false);
    }

    public static ArrayList<String> getCartItems() {
        return Hawk.get(KEY_CART_ITEMS, null);
    }

    public static void setCartItems(ArrayList<String> cartItems) {
        Hawk.put(KEY_CART_ITEMS, cartItems);
    }

    public static ArrayList<String> getFavoriteItems() {
        return Hawk.get(KEY_FAVORITE_ITEMS, null);
    }

    public static void setFavoriteItems(ArrayList<String> cartItems) {
        Hawk.put(KEY_FAVORITE_ITEMS, cartItems);
    }

    public static void setLanguage(SettingsActivity.Language language) {
        Hawk.put(KEY_LANGUAGE, language.toString());
    }

    public static SettingsActivity.Language getLanguage() {
        SettingsActivity.Language language = SettingsActivity.Language.valueOf(Hawk.get(KEY_LANGUAGE, "ENGLISH"));
        return language;
    }

    public static void setCustomerId(String customerId) {
        Hawk.put(CUSTOMER_ID, customerId);
    }

    public static String getCustomerId() {
        return Hawk.get(CUSTOMER_ID, null);
    }
}
