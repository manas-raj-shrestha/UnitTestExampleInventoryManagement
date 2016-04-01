package com.leapfrog.inventorymanagementsystem.dashboard;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.cart.CartActivity;
import com.leapfrog.inventorymanagementsystem.navigationdrawer.OnNavigationOptionSelected;
import com.leapfrog.inventorymanagementsystem.models.Item;
import com.leapfrog.inventorymanagementsystem.navigationdrawer.NavigationDrawerFragment;
import com.leapfrog.inventorymanagementsystem.category.CategoryFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Dashboard screen
 */
public class DashBoardActivity extends AppCompatActivity implements OnNavigationOptionSelected {

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mDrawerToggle;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        ButterKnife.bind(this);
        setToolbar();

        initializeFragments();
        initializeDrawer();



    }

    /**
     * add toolbar action to navigation drawer
     */
    private void initializeDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        );

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    /**
     * initialize fragments
     */
    private void initializeFragments() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_main, new CategoryFragment(Item.ItemType.WIRE));
        fragmentTransaction.add(R.id.fl_navigation_drawer, new NavigationDrawerFragment()).commit();
    }

    /**
     * set toolbar
     */
    private void setToolbar() {
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("MISUMI");
        collapsingToolbarLayout.setTitle("MISUMI");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setHomeAsUpIndicator(ContextCompat.getDrawable(this, R.drawable.ic_dehaze_white_24dp));

    }

    @Override
    public void onNavigationOptionSelected(String option) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        switch (option){
            case "Wire":
                fragmentTransaction.replace(R.id.fl_main,new CategoryFragment(Item.ItemType.WIRE));
                fragmentTransaction.commit();
                break;
            case "Control":
                fragmentTransaction.replace(R.id.fl_main,new CategoryFragment(Item.ItemType.CONTROL));
                fragmentTransaction.commit();
                break;
            case "Knife & Tools":
                fragmentTransaction.replace(R.id.fl_main,new CategoryFragment(Item.ItemType.KNIFE_AND_TOOLS));
                fragmentTransaction.commit();
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }


    @OnClick({R.id.fab_cart})
    public void setOnClicks(View view) {
        switch (view.getId()) {
            case R.id.fab_cart:
                startActivity(new Intent(DashBoardActivity.this, CartActivity.class));
                break;
        }
    }




}
