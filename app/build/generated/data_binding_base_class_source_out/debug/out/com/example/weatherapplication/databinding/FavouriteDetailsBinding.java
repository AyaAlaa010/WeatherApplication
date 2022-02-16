// Generated by data binding compiler. Do not edit!
package com.example.weatherapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.weatherapplication.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FavouriteDetailsBinding extends ViewDataBinding {
  @NonNull
  public final MaterialCardView cardCurrentFavDetails;

  @NonNull
  public final TextView currentAddressFavDetails;

  @NonNull
  public final TextView currentClouds;

  @NonNull
  public final TextView currentDateFavDetails;

  @NonNull
  public final TextView currentDegreeFavDetails;

  @NonNull
  public final TextView currentHumedityFavDetails;

  @NonNull
  public final TextView currentPressureFavDetails;

  @NonNull
  public final TextView currentTempMaxFavDetails;

  @NonNull
  public final TextView currentTempMinFavDetails;

  @NonNull
  public final TextView currentWindFavDetails;

  @NonNull
  public final FrameLayout framFavDetals;

  @NonNull
  public final ImageView imgIconFavDetails;

  @NonNull
  public final RecyclerView recyclerHourFavDetails;

  @NonNull
  public final TextView statusCurrentFavDetails;

  protected FavouriteDetailsBinding(Object _bindingComponent, View _root, int _localFieldCount,
      MaterialCardView cardCurrentFavDetails, TextView currentAddressFavDetails,
      TextView currentClouds, TextView currentDateFavDetails, TextView currentDegreeFavDetails,
      TextView currentHumedityFavDetails, TextView currentPressureFavDetails,
      TextView currentTempMaxFavDetails, TextView currentTempMinFavDetails,
      TextView currentWindFavDetails, FrameLayout framFavDetals, ImageView imgIconFavDetails,
      RecyclerView recyclerHourFavDetails, TextView statusCurrentFavDetails) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cardCurrentFavDetails = cardCurrentFavDetails;
    this.currentAddressFavDetails = currentAddressFavDetails;
    this.currentClouds = currentClouds;
    this.currentDateFavDetails = currentDateFavDetails;
    this.currentDegreeFavDetails = currentDegreeFavDetails;
    this.currentHumedityFavDetails = currentHumedityFavDetails;
    this.currentPressureFavDetails = currentPressureFavDetails;
    this.currentTempMaxFavDetails = currentTempMaxFavDetails;
    this.currentTempMinFavDetails = currentTempMinFavDetails;
    this.currentWindFavDetails = currentWindFavDetails;
    this.framFavDetals = framFavDetals;
    this.imgIconFavDetails = imgIconFavDetails;
    this.recyclerHourFavDetails = recyclerHourFavDetails;
    this.statusCurrentFavDetails = statusCurrentFavDetails;
  }

  @NonNull
  public static FavouriteDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.favourite_details, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FavouriteDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FavouriteDetailsBinding>inflateInternal(inflater, R.layout.favourite_details, root, attachToRoot, component);
  }

  @NonNull
  public static FavouriteDetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.favourite_details, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FavouriteDetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FavouriteDetailsBinding>inflateInternal(inflater, R.layout.favourite_details, null, false, component);
  }

  public static FavouriteDetailsBinding bind(@NonNull View view) {
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
  public static FavouriteDetailsBinding bind(@NonNull View view, @Nullable Object component) {
    return (FavouriteDetailsBinding)bind(component, view, R.layout.favourite_details);
  }
}