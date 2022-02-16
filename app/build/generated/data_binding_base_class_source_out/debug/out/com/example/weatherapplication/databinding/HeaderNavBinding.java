// Generated by data binding compiler. Do not edit!
package com.example.weatherapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.weatherapplication.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class HeaderNavBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imNavHeader;

  protected HeaderNavBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView imNavHeader) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imNavHeader = imNavHeader;
  }

  @NonNull
  public static HeaderNavBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.header_nav, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static HeaderNavBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<HeaderNavBinding>inflateInternal(inflater, R.layout.header_nav, root, attachToRoot, component);
  }

  @NonNull
  public static HeaderNavBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.header_nav, null, false, component)
   */
  @NonNull
  @Deprecated
  public static HeaderNavBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<HeaderNavBinding>inflateInternal(inflater, R.layout.header_nav, null, false, component);
  }

  public static HeaderNavBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static HeaderNavBinding bind(@NonNull View view, @Nullable Object component) {
    return (HeaderNavBinding)bind(component, view, R.layout.header_nav);
  }
}