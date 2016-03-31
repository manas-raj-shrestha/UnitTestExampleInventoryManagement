// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.adapters;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NavigationDrawerRvAdapter$ViewHolder$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.adapters.NavigationDrawerRvAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492990, "field 'tvOption'");
    target.tvOption = finder.castView(view, 2131492990, "field 'tvOption'");
    view = finder.findRequiredView(source, 2131492989, "field 'ivOptionIcon'");
    target.ivOptionIcon = finder.castView(view, 2131492989, "field 'ivOptionIcon'");
  }

  @Override public void unbind(T target) {
    target.tvOption = null;
    target.ivOptionIcon = null;
  }
}
