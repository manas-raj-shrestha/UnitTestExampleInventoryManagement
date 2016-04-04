// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.category;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CategoryFragment$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.category.CategoryFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492998, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131492998, "field 'recyclerView'");
  }

  @Override public void unbind(T target) {
    target.recyclerView = null;
  }
}
