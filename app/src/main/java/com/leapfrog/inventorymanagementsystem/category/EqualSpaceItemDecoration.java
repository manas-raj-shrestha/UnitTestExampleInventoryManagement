package com.leapfrog.inventorymanagementsystem.category;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
