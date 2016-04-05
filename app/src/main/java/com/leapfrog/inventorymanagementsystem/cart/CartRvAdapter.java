package com.leapfrog.inventorymanagementsystem.cart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.data.HawkUtils;
import com.leapfrog.inventorymanagementsystem.events.OnItemSelectListener;
import com.leapfrog.inventorymanagementsystem.models.Inventory;
import com.leapfrog.inventorymanagementsystem.models.Item;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Recycler view adapter for showing cart items
 */
public class CartRvAdapter extends RecyclerView.Adapter<CartRvAdapter.ViewHolder> {
    ArrayList<String> cartItemNames = new ArrayList<>();
    ArrayList<Item> cartItems = new ArrayList<>();
    Context context;
    int totalPrice;
    OnItemSelectListener onItemSelectListener;

    public CartRvAdapter(Context context, OnItemSelectListener onItemSelectListener) {
        this.context = context;
        this.onItemSelectListener = onItemSelectListener;

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
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position < cartItems.size())
            holder.tvItemName.setText(cartItems.get(position).getItemName()
                    + " " + context.getString(R.string.chinese_currency)
                    + cartItems.get(position).getPrice());
        else
            holder.tvItemName.setText(context.getString(R.string.txt_total) + context.getString(R.string.chinese_currency) + totalPrice);
    }

    @Override
    public int getItemCount() {
        return cartItems.size() + 1;
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
                    onItemSelectListener.onItemSelected(cartItems.get(getPosition()), itemView);
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
