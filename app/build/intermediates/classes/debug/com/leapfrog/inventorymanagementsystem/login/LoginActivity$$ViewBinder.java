// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.login.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492996, "field 'edtPassword'");
    target.edtPassword = finder.castView(view, 2131492996, "field 'edtPassword'");
    view = finder.findRequiredView(source, 2131492995, "field 'edtUsername'");
    target.edtUsername = finder.castView(view, 2131492995, "field 'edtUsername'");
  }

  @Override public void unbind(T target) {
    target.edtPassword = null;
    target.edtUsername = null;
  }
}
