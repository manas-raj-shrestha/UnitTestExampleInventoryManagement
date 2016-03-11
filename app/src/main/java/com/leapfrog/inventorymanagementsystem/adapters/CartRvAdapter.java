package com.leapfrog.inventorymanagementsystem.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leapfrog.inventorymanagementsystem.data.HawkUtils;
import com.leapfrog.inventorymanagementsystem.models.Inventory;
import com.leapfrog.inventorymanagementsystem.models.Item;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Manas on 3/10/2016.
 */
public class CartRvAdapter extends RecyclerView.Adapter<CartRvAdapter.ViewHolder> {
    ArrayList<String> cartItemNames = new ArrayList<>();
    ArrayList<Item> cartItems = new ArrayList<>();
    Context context;
    int totalPrice;

    public CartRvAdapter(Context context) {
        this.context = context;

        if (HawkUtils.getCartItems() != null) {
            cartItemNames = HawkUtils.getCartItems();

            for (String cartItemName : cartItemNames) {
                Item item = getItemById(cartItemName);
                cartItems.add(item);
                totalPrice = totalPrice + item.getPrice();
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
        if (position < cartItems.size())
            holder.tvItemName.setText(cartItems.get(position).getItemName() + " $" + cartItems.get(position).getPrice());
        else
            holder.tvItemName.setText("Total : " + totalPrice);
    }

    @Override
    public int getItemCount() {
        return cartItems.size() + 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(android.R.id.text1)
        TextView tvItemName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
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
