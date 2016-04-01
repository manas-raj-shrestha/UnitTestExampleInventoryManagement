package com.leapfrog.inventorymanagementsystem.itemdetail;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.models.Item;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Dialog to select quantity and confirm add to cart
 */
public class AddToCartDialog extends Dialog {
    Item item;
    ItemDetailPresenter itemDetailPresenter;

    @Bind(R.id.iv_add_to_cart)
    ImageView ivAddToCart;

    @Bind(R.id.tv_item_name)
    TextView tvItemName;

    @Bind(R.id.edt_quantity)
    EditText edtQuantity;

    public AddToCartDialog(Context context, Item item, ItemDetailPresenter itemDetailPresenter) {
        super(context);

        this.item = item;
        this.itemDetailPresenter = itemDetailPresenter;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.add_to_cart_dialog);
        ButterKnife.bind(this);

        setUpDialog();
    }

    private void setUpDialog() {
        Glide.with(getContext()).load(item.getPicDrawableId()).into(ivAddToCart);
        tvItemName.setText(item.getItemName());
    }

    @OnClick(R.id.iv_done)
    public void setOnClick(View view) {
        if (!edtQuantity.getText().toString().isEmpty()) {
            itemDetailPresenter.addToCart(item);
            this.dismiss();
        }
    }
}
