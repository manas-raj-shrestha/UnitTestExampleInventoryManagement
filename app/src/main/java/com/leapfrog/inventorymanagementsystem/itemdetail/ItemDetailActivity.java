package com.leapfrog.inventorymanagementsystem.itemdetail;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.data.Extras;
import com.leapfrog.inventorymanagementsystem.models.Item;
import com.leapfrog.inventorymanagementsystem.payment.PaymentActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Shows detail for selected item
 */
public class ItemDetailActivity extends AppCompatActivity implements ItemDetailContract {

    ItemDetailPresenter itemDetailPresenter;

    @Bind(R.id.iv_item_pic)
    ImageView ivItemPic;

    @Bind(R.id.tv_price)
    TextView tvPrice;

    @Bind(R.id.tv_item_desc)
    TextView tvItemDesc;

    @Bind(R.id.tv_brand)
    TextView tvBrand;

    @Bind(R.id.ll_parent)
    LinearLayout linearLayout;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        ButterKnife.bind(this);
        itemDetailPresenter = new ItemDetailPresenter(this);

        setSupportActionBar(toolbar);

        if (getIntent().hasExtra(Extras.KEY_ITEM_EXTRA)) {
            Item item = getIntent().getParcelableExtra(Extras.KEY_ITEM_EXTRA);
            this.item = item;

            Glide.with(this).load(item.getPicDrawableId()).into(ivItemPic);

            setData(item);
        }

        setToolbar();

    }
    private void setToolbar() {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(item.getItemName());
    }

    @Override
    public int getQuantity() {
        return Integer.parseInt("1");
    }

    @Override
    public String getItemCode() {
        return item.getItemCode();
    }

    @Override
    public void purchaseSuccessful() {
        Toast.makeText(ItemDetailActivity.this, getString(R.string.txt_purchase_successful), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void purchaseFailure() {
        Toast.makeText(this, getString(R.string.txt_item_not_available), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAddToCartDialog() {
        AddToCartDialog addToCartDialog = new AddToCartDialog(this, item, itemDetailPresenter);
        addToCartDialog.show();
    }

    public void buyItem(View view) {
        itemDetailPresenter.buyItems();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_detail_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add_to_cart:
//                itemDetailPresenter.addToCart(this.item);
                showAddToCartDialog();
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * set data to views
     *
     * @param item
     */
    private void setData(Item item) {
        tvPrice.setText(getString(R.string.chinese_currency) + item.getPrice());
        tvItemDesc.setText(item.getItemDescription());
        tvBrand.setText(item.getDealerName());
    }
}
