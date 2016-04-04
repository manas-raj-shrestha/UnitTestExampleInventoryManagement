// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.settings;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SettingsActivity$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.settings.SettingsActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492969, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131492969, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131492982, "field 'tvLanguage'");
    target.tvLanguage = finder.castView(view, 2131492982, "field 'tvLanguage'");
    view = finder.findRequiredView(source, 2131492981, "method 'setOnClicks'");
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
    target.toolbar = null;
    target.tvLanguage = null;
  }
}
