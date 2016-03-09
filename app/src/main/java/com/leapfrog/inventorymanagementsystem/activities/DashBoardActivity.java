package com.leapfrog.inventorymanagementsystem.activities;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.data.Extras;
import com.leapfrog.inventorymanagementsystem.models.Item;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Manas on 3/4/2016.
 */
public class DashBoardActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    OnItemSelectListener onItemSelectListener = new OnItemSelectListener() {
        @Override
        public void onItemSelected(Item item) {
            Toast.makeText(DashBoardActivity.this, item.getItemName(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(DashBoardActivity.this, MainActivity.class);
            intent.putExtra(Extras.KEY_ITEM_EXTRA, item);
            startActivity(intent);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        ButterKnife.bind(this);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ItemListAdapter(onItemSelectListener, this));
        recyclerView.addItemDecoration(new EqualSpaceItemDecoration(10));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
