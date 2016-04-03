// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.favorites;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class FavoritesActivity$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.favorites.FavoritesActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492969, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131492969, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131492980, "field 'rvCart'");
    target.rvCart = finder.castView(view, 2131492980, "field 'rvCart'");
  }

  @Override public void unbind(T target) {
    target.toolbar = null;
    target.rvCart = null;
  }
}
