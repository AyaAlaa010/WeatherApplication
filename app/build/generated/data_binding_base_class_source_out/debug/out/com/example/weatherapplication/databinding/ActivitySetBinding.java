// Generated by data binding compiler. Do not edit!
package com.example.weatherapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.weatherapplication.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivitySetBinding extends ViewDataBinding {
  @NonNull
  public final CardView cardGroubWind;

  @NonNull
  public final CardView cardGroupTemp;

  @NonNull
  public final MaterialCardView cardLocation;

  @NonNull
  public final CardView cardLocationForRadio;

  @NonNull
  public final MaterialCardView cardNotifications;

  @NonNull
  public final MaterialCardView cardTemp;

  @NonNull
  public final MaterialCardView cardWind;

  @NonNull
  public final RadioGroup radioGroupLocation;

  @NonNull
  public final RadioGroup radioGroupNotifications;

  @NonNull
  public final RadioGroup radioGroupWind;

  @NonNull
  public final RadioGroup radioGroupp;

  @NonNull
  public final RadioButton toggeDegreeCelsiuss;

  @NonNull
  public final RadioButton toggeMap;

  @NonNull
  public final RadioButton toggeMs;

  @NonNull
  public final RadioButton toggeNotificationsOn;

  @NonNull
  public final RadioButton toggelFahrenheitt;

  @NonNull
  public final RadioButton toggelGps;

  @NonNull
  public final RadioButton toggelKelvinn;

  @NonNull
  public final RadioButton toggelMh;

  @NonNull
  public final RadioButton toggelNotificationsOff;

  @NonNull
  public final TextView tvLocation;

  @NonNull
  public final TextView tvNotifications;

  @NonNull
  public final TextView tvTempreture;

  @NonNull
  public final TextView tvWindSpeed;

  protected ActivitySetBinding(Object _bindingComponent, View _root, int _localFieldCount,
      CardView cardGroubWind, CardView cardGroupTemp, MaterialCardView cardLocation,
      CardView cardLocationForRadio, MaterialCardView cardNotifications, MaterialCardView cardTemp,
      MaterialCardView cardWind, RadioGroup radioGroupLocation, RadioGroup radioGroupNotifications,
      RadioGroup radioGroupWind, RadioGroup radioGroupp, RadioButton toggeDegreeCelsiuss,
      RadioButton toggeMap, RadioButton toggeMs, RadioButton toggeNotificationsOn,
      RadioButton toggelFahrenheitt, RadioButton toggelGps, RadioButton toggelKelvinn,
      RadioButton toggelMh, RadioButton toggelNotificationsOff, TextView tvLocation,
      TextView tvNotifications, TextView tvTempreture, TextView tvWindSpeed) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cardGroubWind = cardGroubWind;
    this.cardGroupTemp = cardGroupTemp;
    this.cardLocation = cardLocation;
    this.cardLocationForRadio = cardLocationForRadio;
    this.cardNotifications = cardNotifications;
    this.cardTemp = cardTemp;
    this.cardWind = cardWind;
    this.radioGroupLocation = radioGroupLocation;
    this.radioGroupNotifications = radioGroupNotifications;
    this.radioGroupWind = radioGroupWind;
    this.radioGroupp = radioGroupp;
    this.toggeDegreeCelsiuss = toggeDegreeCelsiuss;
    this.toggeMap = toggeMap;
    this.toggeMs = toggeMs;
    this.toggeNotificationsOn = toggeNotificationsOn;
    this.toggelFahrenheitt = toggelFahrenheitt;
    this.toggelGps = toggelGps;
    this.toggelKelvinn = toggelKelvinn;
    this.toggelMh = toggelMh;
    this.toggelNotificationsOff = toggelNotificationsOff;
    this.tvLocation = tvLocation;
    this.tvNotifications = tvNotifications;
    this.tvTempreture = tvTempreture;
    this.tvWindSpeed = tvWindSpeed;
  }

  @NonNull
  public static ActivitySetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_set, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivitySetBinding>inflateInternal(inflater, R.layout.activity_set, root, attachToRoot, component);
  }

  @NonNull
  public static ActivitySetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_set, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivitySetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivitySetBinding>inflateInternal(inflater, R.layout.activity_set, null, false, component);
  }

  public static ActivitySetBinding bind(@NonNull View view) {
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
  public static ActivitySetBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivitySetBinding)bind(component, view, R.layout.activity_set);
  }
}