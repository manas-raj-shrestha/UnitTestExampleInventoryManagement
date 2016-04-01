// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.favorites;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class FavoritesRvAdapter$ViewHolder$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.favorites.FavoritesRvAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 16908308, "field 'tvItemName'");
    target.tvItemName = finder.castView(view, 16908308, "field 'tvItemName'");
  }

  @Override public void unbind(T target) {
    target.tvItemName = null;
  }
}
