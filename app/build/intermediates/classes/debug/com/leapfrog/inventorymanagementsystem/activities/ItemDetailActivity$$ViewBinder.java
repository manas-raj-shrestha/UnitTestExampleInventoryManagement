// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.activities;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ItemDetailActivity$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.activities.ItemDetailActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492970, "field 'ivItemPic'");
    target.ivItemPic = finder.castView(view, 2131492970, "field 'ivItemPic'");
    view = finder.findRequiredView(source, 2131492971, "field 'tvPrice'");
    target.tvPrice = finder.castView(view, 2131492971, "field 'tvPrice'");
    view = finder.findRequiredView(source, 2131492968, "field 'linearLayout'");
    target.linearLayout = finder.castView(view, 2131492968, "field 'linearLayout'");
    view = finder.findRequiredView(source, 2131492969, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131492969, "field 'toolbar'");
  }

  @Override public void unbind(T target) {
    target.ivItemPic = null;
    target.tvPrice = null;
    target.linearLayout = null;
    target.toolbar = null;
  }
}
