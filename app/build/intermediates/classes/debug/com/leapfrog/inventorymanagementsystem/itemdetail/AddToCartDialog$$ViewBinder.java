// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.itemdetail;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class AddToCartDialog$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.itemdetail.AddToCartDialog> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492976, "field 'ivAddToCart'");
    target.ivAddToCart = finder.castView(view, 2131492976, "field 'ivAddToCart'");
    view = finder.findRequiredView(source, 2131492977, "field 'tvItemName'");
    target.tvItemName = finder.castView(view, 2131492977, "field 'tvItemName'");
    view = finder.findRequiredView(source, 2131492978, "field 'edtQuantity'");
    target.edtQuantity = finder.castView(view, 2131492978, "field 'edtQuantity'");
    view = finder.findRequiredView(source, 2131492979, "method 'setOnClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.setOnClick(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.ivAddToCart = null;
    target.tvItemName = null;
    target.edtQuantity = null;
  }
}
