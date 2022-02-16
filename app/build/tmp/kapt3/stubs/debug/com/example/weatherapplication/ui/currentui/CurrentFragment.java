package com.example.weatherapplication.ui.currentui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u00107\u001a\u00020\u001aJ\b\u00108\u001a\u00020\u001aH\u0002J\b\u00109\u001a\u00020\u001aH\u0002J\u0006\u0010:\u001a\u00020\u001aJ0\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004H\u0002J\u000e\u0010B\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010C\u001a\u00020\u001aJ\b\u0010D\u001a\u00020\u001aH\u0002J&\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020\u001aH\u0016J+\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040R2\u0006\u0010S\u001a\u00020TH\u0016\u00a2\u0006\u0002\u0010UJ\b\u0010V\u001a\u00020\u001aH\u0016J\u001a\u0010W\u001a\u00020\u001a2\u0006\u0010X\u001a\u00020F2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010Y\u001a\u00020\u001aH\u0002J\b\u0010Z\u001a\u00020\u001aH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006["}, d2 = {"Lcom/example/weatherapplication/ui/currentui/CurrentFragment;", "Landroidx/fragment/app/Fragment;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "binding", "Lcom/example/weatherapplication/databinding/FragmentCurrentBinding;", "getBinding", "()Lcom/example/weatherapplication/databinding/FragmentCurrentBinding;", "setBinding", "(Lcom/example/weatherapplication/databinding/FragmentCurrentBinding;)V", "currentEntity", "Lcom/example/weatherapplication/data/local/current/CurrentEntity;", "getCurrentEntity", "()Lcom/example/weatherapplication/data/local/current/CurrentEntity;", "setCurrentEntity", "(Lcom/example/weatherapplication/data/local/current/CurrentEntity;)V", "hourlyViewModel", "Lcom/example/weatherapplication/viewmodels/HourlyViewModel;", "language", "getLanguage", "setLanguage", "(Ljava/lang/String;)V", "lastLocation", "", "getLastLocation", "()Lkotlin/Unit;", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "getLocationCallback", "()Lcom/google/android/gms/location/LocationCallback;", "setLocationCallback", "(Lcom/google/android/gms/location/LocationCallback;)V", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "getLocationRequest", "()Lcom/google/android/gms/location/LocationRequest;", "setLocationRequest", "(Lcom/google/android/gms/location/LocationRequest;)V", "mfusedLocationProviderclient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getMfusedLocationProviderclient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "setMfusedLocationProviderclient", "(Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "myadapter", "Lcom/example/weatherapplication/ui/currentui/CurrentAdapter;", "getMyadapter", "()Lcom/example/weatherapplication/ui/currentui/CurrentAdapter;", "setMyadapter", "(Lcom/example/weatherapplication/ui/currentui/CurrentAdapter;)V", "viewModel", "Lcom/example/weatherapplication/viewmodels/WeatherViewModel;", "askLocationPermision", "checkSettingAndStartLocationUpdate", "initLocationRequest", "initOnlineData", "initViews", "lat", "", "lon", "exclude", "lang", "unites", "initoflineData", "observeHourly", "observeViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onStart", "onViewCreated", "view", "startLocationUpdates", "stopLocationUpdates", "app_debug"})
public final class CurrentFragment extends androidx.fragment.app.Fragment {
    public com.example.weatherapplication.databinding.FragmentCurrentBinding binding;
    @org.jetbrains.annotations.Nullable()
    private com.example.weatherapplication.ui.currentui.CurrentAdapter myadapter;
    private com.example.weatherapplication.viewmodels.WeatherViewModel viewModel;
    private com.example.weatherapplication.viewmodels.HourlyViewModel hourlyViewModel;
    public com.google.android.gms.location.FusedLocationProviderClient mfusedLocationProviderclient;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "current";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String language = "en";
    @org.jetbrains.annotations.NotNull()
    private com.example.weatherapplication.data.local.current.CurrentEntity currentEntity;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.location.LocationRequest locationRequest;
    @org.jetbrains.annotations.NotNull()
    private com.google.android.gms.location.LocationCallback locationCallback;
    
    public CurrentFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.weatherapplication.databinding.FragmentCurrentBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.databinding.FragmentCurrentBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.weatherapplication.ui.currentui.CurrentAdapter getMyadapter() {
        return null;
    }
    
    public final void setMyadapter(@org.jetbrains.annotations.Nullable()
    com.example.weatherapplication.ui.currentui.CurrentAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.location.FusedLocationProviderClient getMfusedLocationProviderclient() {
        return null;
    }
    
    public final void setMfusedLocationProviderclient(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.FusedLocationProviderClient p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    public final void setLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.weatherapplication.data.local.current.CurrentEntity getCurrentEntity() {
        return null;
    }
    
    public final void setCurrentEntity(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.data.local.current.CurrentEntity p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void initOnlineData() {
    }
    
    private final void checkSettingAndStartLocationUpdate() {
    }
    
    public final void askLocationPermision() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final kotlin.Unit getLastLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.location.LocationRequest getLocationRequest() {
        return null;
    }
    
    public final void setLocationRequest(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.location.LocationRequest p0) {
    }
    
    private final void initLocationRequest() {
    }
    
    private final void startLocationUpdates() {
    }
    
    private final void stopLocationUpdates() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.location.LocationCallback getLocationCallback() {
        return null;
    }
    
    public final void setLocationCallback(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.LocationCallback p0) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    public final void observeHourly() {
    }
    
    private final void observeViewModel() {
    }
    
    public final void initoflineData(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.data.local.current.CurrentEntity currentEntity) {
    }
    
    private final void initViews(double lat, double lon, java.lang.String exclude, java.lang.String lang, java.lang.String unites) {
    }
}