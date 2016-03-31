package com.leapfrog.inventorymanagementsystem.navigationdrawer;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.cart.CartActivity;
import com.leapfrog.inventorymanagementsystem.activities.FavoritesActivity;
import com.leapfrog.inventorymanagementsystem.events.OnNavigationOptionSelected;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * View for navigation drawer
 */
public class NavigationDrawerFragment extends Fragment {

    @Bind(R.id.recycler_view_nav_drawer)
    RecyclerView recyclerViewNavDrawer;

    @Bind(R.id.iv_user_pic)
    ImageView ivUserPic;

    OnNavigationOptionSelected dashBoardNavigationListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewNavDrawer.setAdapter(new NavigationDrawerRvAdapter(getActivity(), dashBoardNavigationListener));
        recyclerViewNavDrawer.setLayoutManager(new LinearLayoutManager(getActivity()));

        Glide.with(this).load(R.drawable.user_pic).asBitmap().centerCrop().into(new BitmapImageViewTarget(ivUserPic) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                ivUserPic.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        dashBoardNavigationListener = (OnNavigationOptionSelected) activity;
    }
}
