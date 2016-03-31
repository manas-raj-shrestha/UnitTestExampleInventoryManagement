// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.navigationdrawer;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NavigationDrawerFragment$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.navigationdrawer.NavigationDrawerFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492980, "field 'recyclerViewNavDrawer'");
    target.recyclerViewNavDrawer = finder.castView(view, 2131492980, "field 'recyclerViewNavDrawer'");
    view = finder.findRequiredView(source, 2131492979, "field 'ivUserPic'");
    target.ivUserPic = finder.castView(view, 2131492979, "field 'ivUserPic'");
  }

  @Override public void unbind(T target) {
    target.recyclerViewNavDrawer = null;
    target.ivUserPic = null;
  }
}
