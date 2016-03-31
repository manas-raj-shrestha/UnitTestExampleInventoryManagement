// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.activities;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.activities.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492991, "field 'edtPassword'");
    target.edtPassword = finder.castView(view, 2131492991, "field 'edtPassword'");
    view = finder.findRequiredView(source, 2131492990, "field 'edtUsername'");
    target.edtUsername = finder.castView(view, 2131492990, "field 'edtUsername'");
  }

  @Override public void unbind(T target) {
    target.edtPassword = null;
    target.edtUsername = null;
  }
}
