package com.leapfrog.inventorymanagementsystem.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.adapters.NavigationDrawerRvAdapter;
import com.leapfrog.inventorymanagementsystem.events.OnNavigationOptionSelected;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * View for navigation drawer
 */
public class NavigationDrawerFragment extends Fragment {

    @Bind(R.id.recycler_view_nav_drawer)
    RecyclerView recyclerViewNavDrawer;

    OnNavigationOptionSelected onNavigationOptionSelected = new OnNavigationOptionSelected() {
        @Override
        public void onNavigationOptionSelected(String option) {
            switch (option) {
                case "Cart":
                    Log.e("cart selected", "cart selected");
                    break;
                case "Favorites":
                    break;
                case "Log Out":
                    break;
            }

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewNavDrawer.setAdapter(new NavigationDrawerRvAdapter(getActivity(), onNavigationOptionSelected));
        recyclerViewNavDrawer.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
