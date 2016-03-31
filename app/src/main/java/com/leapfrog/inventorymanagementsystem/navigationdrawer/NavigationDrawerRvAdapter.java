package com.leapfrog.inventorymanagementsystem.navigationdrawer;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.events.OnNavigationOptionSelected;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Adapter for {@link RecyclerView} of navigation drawer
 */
public class NavigationDrawerRvAdapter extends RecyclerView.Adapter<NavigationDrawerRvAdapter.ViewHolder> {

    private final static String[] options = new String[]{"Wire", "Control", "Knife & Tools"};
    private final static int[] optionIcons = new int[]{R.drawable.ic_shopping_cart_grey_24dp,
            R.drawable.ic_favorite_grey_24dp, R.drawable.ic_exit_to_app_grey_24dp};

    private Context context;
    private OnNavigationOptionSelected onNavigationOptionSelected;

    public NavigationDrawerRvAdapter(Context context, OnNavigationOptionSelected onNavigationOptionSelected) {
        this.context = context;
        this.onNavigationOptionSelected = onNavigationOptionSelected;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.navigation_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvOption.setText(options[position]);
        holder.ivOptionIcon.setImageDrawable(ContextCompat.getDrawable(context, optionIcons[position]));
    }

    @Override
    public int getItemCount() {
        return options.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.tv_option_name)
        TextView tvOption;

        @Bind(R.id.iv_option_icon)
        ImageView ivOptionIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNavigationOptionSelected.onNavigationOptionSelected(tvOption.getText().toString());
        }
    }
}
