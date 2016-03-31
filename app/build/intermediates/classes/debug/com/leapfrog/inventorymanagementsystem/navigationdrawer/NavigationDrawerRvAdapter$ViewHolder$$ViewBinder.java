// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.navigationdrawer;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NavigationDrawerRvAdapter$ViewHolder$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.navigationdrawer.NavigationDrawerRvAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 16908308, "field 'tvOption'");
    target.tvOption = finder.castView(view, 16908308, "field 'tvOption'");
  }

  @Override public void unbind(T target) {
    target.tvOption = null;
  }
}
