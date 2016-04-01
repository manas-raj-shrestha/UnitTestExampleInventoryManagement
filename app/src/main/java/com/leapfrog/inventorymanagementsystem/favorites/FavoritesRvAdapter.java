package com.leapfrog.inventorymanagementsystem.favorites;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leapfrog.inventorymanagementsystem.data.HawkUtils;
import com.leapfrog.inventorymanagementsystem.events.OnItemSelectListener;
import com.leapfrog.inventorymanagementsystem.models.Inventory;
import com.leapfrog.inventorymanagementsystem.models.Item;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Manas on 3/14/2016.
 */
public class FavoritesRvAdapter extends RecyclerView.Adapter<FavoritesRvAdapter.ViewHolder> {

    ArrayList<String> favItemNames = new ArrayList<>();
    ArrayList<Item> favoriteItems = new ArrayList<>();
    Context context;
    OnItemSelectListener onItemSelectListener;

    public FavoritesRvAdapter(Context context, OnItemSelectListener onItemSelectListener) {
        this.context = context;
        this.onItemSelectListener = onItemSelectListener;

        if (HawkUtils.getFavoriteItems() != null) {
            favItemNames = HawkUtils.getFavoriteItems();

            for (String favItemName : favItemNames) {
                Item item = getItemById(favItemName);
                favoriteItems.add(item);
            }

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvItemName.setText(favoriteItems.get(position).getItemName() + " $" + favoriteItems.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return favoriteItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(android.R.id.text1)
        TextView tvItemName;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemSelectListener.onItemSelected(favoriteItems.get(getPosition()), itemView);
                }
            });

        }

    }

    /**
     * search item by id
     *
     * @param itemCode item code
     * @return {@link Item}
     */
    private Item getItemById(String itemCode) {
        ArrayList<Item> items = Inventory.items;

        for (Item item : items) {
            if (item.getItemCode().equals(itemCode)) {
                return item;
            }
        }

        return null;
    }
}
