package com.leapfrog.inventorymanagementsystem.cart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.itemdetail.ItemDetailActivity;
import com.leapfrog.inventorymanagementsystem.data.Extras;
import com.leapfrog.inventorymanagementsystem.events.OnItemSelectListener;
import com.leapfrog.inventorymanagementsystem.models.Item;
import com.leapfrog.inventorymanagementsystem.payment.PaymentActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Shows cart items
 */
public class CartActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.rv_cart)
    RecyclerView rvCart;


    OnItemSelectListener onItemSelectListener = new OnItemSelectListener() {
        @Override
        public void onItemSelected(Item item, View view) {
            Toast.makeText(CartActivity.this, item.getItemName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CartActivity.this, ItemDetailActivity.class);
            intent.putExtra(Extras.KEY_ITEM_EXTRA, item);
            startActivity(intent);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_activity);

        ButterKnife.bind(this);

        setRecyclerView();
        setToolbar();
    }

    /**
     * set up recycler view for cart items
     */
    private void setRecyclerView() {
        rvCart.setAdapter(new CartRvAdapter(this, onItemSelectListener));
        rvCart.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * set up toolbar
     */
    private void setToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getString(R.string.txt_cart));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.btn_make_payment})
    public void makePayment() {
        startActivity(new Intent(CartActivity.this, PaymentActivity.class));
    }
}
