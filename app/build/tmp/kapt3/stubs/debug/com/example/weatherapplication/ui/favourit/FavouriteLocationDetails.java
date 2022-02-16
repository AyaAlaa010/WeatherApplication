package com.example.weatherapplication.ui.favourit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fH\u0002J\u0006\u0010!\u001a\u00020\u001aJ\b\u0010\"\u001a\u00020\u001aH\u0002J\u0012\u0010#\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/example/weatherapplication/ui/favourit/FavouriteLocationDetails;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/weatherapplication/databinding/FavouriteDetailsBinding;", "getBinding", "()Lcom/example/weatherapplication/databinding/FavouriteDetailsBinding;", "setBinding", "(Lcom/example/weatherapplication/databinding/FavouriteDetailsBinding;)V", "hourlyViewModel", "Lcom/example/weatherapplication/viewmodels/HourlyViewModel;", "language", "", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "myadapter", "Lcom/example/weatherapplication/ui/currentui/CurrentAdapter;", "getMyadapter", "()Lcom/example/weatherapplication/ui/currentui/CurrentAdapter;", "setMyadapter", "(Lcom/example/weatherapplication/ui/currentui/CurrentAdapter;)V", "viewModel", "Lcom/example/weatherapplication/viewmodels/WeatherViewModel;", "initViews", "", "lat", "", "lon", "exclude", "lang", "unites", "observeHourly", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class FavouriteLocationDetails extends androidx.appcompat.app.AppCompatActivity {
    public com.example.weatherapplication.databinding.FavouriteDetailsBinding binding;
    private com.example.weatherapplication.viewmodels.WeatherViewModel viewModel;
    private com.example.weatherapplication.viewmodels.HourlyViewModel hourlyViewModel;
    @org.jetbrains.annotations.Nullable()
    private com.example.weatherapplication.ui.currentui.CurrentAdapter myadapter;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String language = "en";
    
    public FavouriteLocationDetails() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.weatherapplication.databinding.FavouriteDetailsBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.databinding.FavouriteDetailsBinding p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.weatherapplication.ui.currentui.CurrentAdapter getMyadapter() {
        return null;
    }
    
    public final void setMyadapter(@org.jetbrains.annotations.Nullable()
    com.example.weatherapplication.ui.currentui.CurrentAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    public final void setLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews(double lat, double lon, java.lang.String exclude, java.lang.String lang, java.lang.String unites) {
    }
    
    public final void observeHourly() {
    }
    
    private final void observeViewModel() {
    }
}