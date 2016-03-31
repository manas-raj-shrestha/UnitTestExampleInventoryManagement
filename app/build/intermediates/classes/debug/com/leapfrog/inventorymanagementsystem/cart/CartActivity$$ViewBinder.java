// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.cart;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CartActivity$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.cart.CartActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492969, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131492969, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131492972, "field 'rvCart'");
    target.rvCart = finder.castView(view, 2131492972, "field 'rvCart'");
  }

  @Override public void unbind(T target) {
    target.toolbar = null;
    target.rvCart = null;
  }
}
