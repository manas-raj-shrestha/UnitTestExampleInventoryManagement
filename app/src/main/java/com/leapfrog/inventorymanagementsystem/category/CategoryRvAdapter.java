package com.leapfrog.inventorymanagementsystem.category;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.leapfrog.inventorymanagementsystem.utils.GeneralUtils;
import com.leapfrog.inventorymanagementsystem.events.OnItemSelectListener;
import com.leapfrog.inventorymanagementsystem.models.Inventory;
import com.leapfrog.inventorymanagementsystem.models.Item;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * {@link android.support.v7.widget.RecyclerView.Adapter} to filter and show the item
 * according to their item type(category)
 */
public class CategoryRvAdapter extends RecyclerView.Adapter<CategoryRvAdapter.ViewHolder> {
    private static final String TAG = CategoryRvAdapter.class.getSimpleName();
    //Inventory inventory = Inventory.getInstance();
    Inventory inventory=Inventory.getInstance();
    ArrayList<Item> item = new ArrayList<>();
    OnItemSelectListener onItemSelectListener;
    Context context;

    public CategoryRvAdapter(OnItemSelectListener onItemSelectListener,
                             Context context, Item.ItemType category) {
        item = GeneralUtils.filterItems(inventory.items, category);
        this.onItemSelectListener = onItemSelectListener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CustomItemViewGroup customItemViewGroup = new CustomItemViewGroup(context, onItemSelectListener);
        return new ViewHolder(customItemViewGroup);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ((CustomItemViewGroup) (holder.itemView)).setData(item.get(position));
    }

    public void updateAdapter() {
        item.clear();
        inventory.loadInventory();
        item.addAll(inventory.items);
        Log.i(TAG, "updateAdapter: size of item "+ inventory.items.get(0).getItemName());
        //Log.i(TAG, "updateAdapter: data"+ item.get(0).getItemName());
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
