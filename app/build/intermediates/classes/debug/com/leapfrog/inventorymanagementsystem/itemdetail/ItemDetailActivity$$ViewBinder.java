// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.itemdetail;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ItemDetailActivity$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.itemdetail.ItemDetailActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492970, "field 'ivItemPic'");
    target.ivItemPic = finder.castView(view, 2131492970, "field 'ivItemPic'");
    view = finder.findRequiredView(source, 2131492972, "field 'tvPrice'");
    target.tvPrice = finder.castView(view, 2131492972, "field 'tvPrice'");
    view = finder.findRequiredView(source, 2131492971, "field 'tvItemDesc'");
    target.tvItemDesc = finder.castView(view, 2131492971, "field 'tvItemDesc'");
    view = finder.findRequiredView(source, 2131492973, "field 'tvBrand'");
    target.tvBrand = finder.castView(view, 2131492973, "field 'tvBrand'");
    view = finder.findRequiredView(source, 2131492968, "field 'linearLayout'");
    target.linearLayout = finder.castView(view, 2131492968, "field 'linearLayout'");
    view = finder.findRequiredView(source, 2131492969, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131492969, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131492974, "field 'btnMakePayment'");
    target.btnMakePayment = finder.castView(view, 2131492974, "field 'btnMakePayment'");
  }

  @Override public void unbind(T target) {
    target.ivItemPic = null;
    target.tvPrice = null;
    target.tvItemDesc = null;
    target.tvBrand = null;
    target.linearLayout = null;
    target.toolbar = null;
    target.btnMakePayment = null;
  }
}
