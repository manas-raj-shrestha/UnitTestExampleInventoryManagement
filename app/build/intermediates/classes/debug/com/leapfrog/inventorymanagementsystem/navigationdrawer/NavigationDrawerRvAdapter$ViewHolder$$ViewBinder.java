// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.navigationdrawer;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NavigationDrawerRvAdapter$ViewHolder$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.navigationdrawer.NavigationDrawerRvAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492991, "field 'tvOption'");
    target.tvOption = finder.castView(view, 2131492991, "field 'tvOption'");
    view = finder.findRequiredView(source, 2131492990, "field 'ivOptionIcon'");
    target.ivOptionIcon = finder.castView(view, 2131492990, "field 'ivOptionIcon'");
  }

  @Override public void unbind(T target) {
    target.tvOption = null;
    target.ivOptionIcon = null;
  }
}
