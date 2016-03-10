package com.leapfrog.inventorymanagementsystem.activities;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.data.Extras;
import com.leapfrog.inventorymanagementsystem.data.HawkUtils;
import com.leapfrog.inventorymanagementsystem.models.Item;
import com.leapfrog.inventorymanagementsystem.utils.GeneralUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Manas on 3/4/2016.
 */
public class DashBoardActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    OnItemSelectListener onItemSelectListener = new OnItemSelectListener() {
        @Override
        public void onItemSelected(Item item, View view) {
            Toast.makeText(DashBoardActivity.this, item.getItemName(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(DashBoardActivity.this, ItemDetailActivity.class);
            intent.putExtra(Extras.KEY_ITEM_EXTRA, item);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(DashBoardActivity.this, view, "itempic");
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        ButterKnife.bind(this);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        setToolbar();

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ItemListAdapter(onItemSelectListener, this));
        recyclerView.addItemDecoration(new EqualSpaceItemDecoration((int) GeneralUtils.convertDpToPixel(4, DashBoardActivity.this)));

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Hello");
        stringArrayList.add("World");

        HawkUtils.setCartItems(stringArrayList);
        Log.e("size", HawkUtils.getCartItems().toString() + " NA");
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Shopflix");
        collapsingToolbarLayout.setTitle("Shopflix");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    /**
     * {@link android.support.v7.widget.RecyclerView.ItemDecoration} for recycler view
     */
    public class EqualSpaceItemDecoration extends RecyclerView.ItemDecoration {

        private final int mSpaceHeight;

        public EqualSpaceItemDecoration(int mSpaceHeight) {
            this.mSpaceHeight = mSpaceHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.bottom = mSpaceHeight;
            outRect.left = mSpaceHeight;
            outRect.right = mSpaceHeight;
            outRect.top = mSpaceHeight;
        }
    }
}
