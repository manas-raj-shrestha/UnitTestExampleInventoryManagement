package com.leapfrog.inventorymanagementsystem.data;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;

/**
 * Shared preference handler/manager for app using Hawk utils
 */
public class HawkUtils {
    private static final String KEY_LOGIN_STATUS = "login_status";
    private static final String KEY_CART_ITEMS = "cart_items";
    private static final String KEY_FAVORITE_ITEMS = "fav_items";

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
}
