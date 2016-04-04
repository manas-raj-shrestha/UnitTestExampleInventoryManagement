// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.dashboard;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class DashBoardActivity$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.dashboard.DashBoardActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492988, "field 'mDrawerLayout'");
    target.mDrawerLayout = finder.castView(view, 2131492988, "field 'mDrawerLayout'");
    view = finder.findRequiredView(source, 2131492969, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131492969, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131492990, "field 'collapsingToolbarLayout'");
    target.collapsingToolbarLayout = finder.castView(view, 2131492990, "field 'collapsingToolbarLayout'");
    view = finder.findRequiredView(source, 2131492992, "method 'setOnClicks'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOnClicks(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.mDrawerLayout = null;
    target.toolbar = null;
    target.collapsingToolbarLayout = null;
  }
}
