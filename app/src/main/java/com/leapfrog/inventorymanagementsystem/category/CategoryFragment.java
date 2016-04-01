package com.leapfrog.inventorymanagementsystem.category;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.itemdetail.ItemDetailActivity;
import com.leapfrog.inventorymanagementsystem.data.Extras;
import com.leapfrog.inventorymanagementsystem.events.OnItemSelectListener;
import com.leapfrog.inventorymanagementsystem.models.Item;
import com.leapfrog.inventorymanagementsystem.utils.GeneralUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Contains recycle view to show items according to selected category
 */
public class CategoryFragment extends Fragment {

    private static final int ITEMS_PER_ROW = 2;
    private final Item.ItemType itemType;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    public CategoryFragment (Item.ItemType itemType){
        this.itemType = itemType;
    }

    OnItemSelectListener onItemSelectListener = new OnItemSelectListener() {
        @Override
        public void onItemSelected(Item item, View view) {

            Intent intent = new Intent(getActivity(), ItemDetailActivity.class);
            intent.putExtra(Extras.KEY_ITEM_EXTRA, item);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(getActivity(), view, "itempic");
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wire_category, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(ITEMS_PER_ROW, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(new CategoryRvAdapter(onItemSelectListener, getActivity(), itemType));
        recyclerView.addItemDecoration(new EqualSpaceItemDecoration((int) GeneralUtils.convertDpToPixel(4, getActivity())));
    }
}
