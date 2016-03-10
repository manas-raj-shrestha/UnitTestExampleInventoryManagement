package com.leapfrog.inventorymanagementsystem.activities;

import android.view.View;

import com.leapfrog.inventorymanagementsystem.models.Item;

/**
 * Item selection listener for recycler view
 */
public interface OnItemSelectListener {
    void onItemSelected(Item item,View view);
}
