package com.leapfrog.inventorymanagementsystem.cart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.data.Extras;
import com.leapfrog.inventorymanagementsystem.events.OnItemSelectListener;
import com.leapfrog.inventorymanagementsystem.itemdetail.ItemDetailActivity;
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
        rvCart.addItemDecoration(new SimpleDividerItemDecoration(this));
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


    @OnClick({R.id.btn_make_payment, R.id.btn_make_payment_wechat})
    public void makePayment(View view) {
        int payment = PaymentActivity.PAYMENT_STRIPE;
        switch (view.getId()) {
            case R.id.btn_make_payment:
                payment = PaymentActivity.PAYMENT_STRIPE;
                break;
            case R.id.btn_make_payment_wechat:
                payment = PaymentActivity.PAYMENT_WEPAY;
                break;
        }
        startActivity(PaymentActivity.launchActivity(this, payment));
    }


    class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
        private Drawable mDivider;

        public SimpleDividerItemDecoration(Context context) {
            mDivider = context.getResources().getDrawable(R.drawable.line_divider);
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();

            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }

    }
}
