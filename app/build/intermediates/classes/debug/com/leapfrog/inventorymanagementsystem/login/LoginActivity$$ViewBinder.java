// Generated code from Butter Knife. Do not modify!
package com.leapfrog.inventorymanagementsystem.login;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends com.leapfrog.inventorymanagementsystem.login.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131493004, "field 'edtPassword'");
    target.edtPassword = finder.castView(view, 2131493004, "field 'edtPassword'");
    view = finder.findRequiredView(source, 2131493003, "field 'edtUsername'");
    target.edtUsername = finder.castView(view, 2131493003, "field 'edtUsername'");
  }

  @Override public void unbind(T target) {
    target.edtPassword = null;
    target.edtUsername = null;
  }
}
