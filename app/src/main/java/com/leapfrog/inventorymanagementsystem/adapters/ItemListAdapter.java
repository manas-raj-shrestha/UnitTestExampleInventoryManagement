package com.leapfrog.inventorymanagementsystem.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.events.OnItemSelectListener;
import com.leapfrog.inventorymanagementsystem.models.Inventory;
import com.leapfrog.inventorymanagementsystem.models.Item;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Manas on 3/4/2016.
 */
public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {
    Inventory inventory = Inventory.getInstance();
    ArrayList<Item> items = new ArrayList<>();
    OnItemSelectListener onItemSelectListener;
    Context context;

    public ItemListAdapter(OnItemSelectListener onItemSelectListener,
                           Context context) {
        items = inventory.items;
        this.onItemSelectListener = onItemSelectListener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvItemName.setText(items.get(position).getItemName());
        holder.tvDealerName.setText(items.get(position).getDealerName());
        holder.tvPrice.setText("$" + items.get(position).getPrice());
        Glide.with(context).load(items.get(position).getPicDrawableId()).fitCenter().into(holder.ivItemPic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_item_name)
        TextView tvItemName;

        @Bind(R.id.iv_item_pic)
        ImageView ivItemPic;

        @Bind(R.id.tv_dealer_name)
        TextView tvDealerName;

        @Bind(R.id.tv_price)
        TextView tvPrice;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemSelectListener.onItemSelected(items.get(getPosition()), ivItemPic);
                }
            });
        }
    }
}
