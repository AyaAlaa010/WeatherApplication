package com.example.weatherapplication.ui.nextdays;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ0\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0010H\u0002J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001a\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0006\u0010.\u001a\u00020\u001cR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006/"}, d2 = {"Lcom/example/weatherapplication/ui/nextdays/NextFragment;", "Landroidx/fragment/app/Fragment;", "()V", "dailyViewModel", "Lcom/example/weatherapplication/viewmodels/DailyViewModel;", "getDailyViewModel", "()Lcom/example/weatherapplication/viewmodels/DailyViewModel;", "setDailyViewModel", "(Lcom/example/weatherapplication/viewmodels/DailyViewModel;)V", "fragmentNextBinding", "Lcom/example/weatherapplication/databinding/FragmentNextBinding;", "getFragmentNextBinding", "()Lcom/example/weatherapplication/databinding/FragmentNextBinding;", "setFragmentNextBinding", "(Lcom/example/weatherapplication/databinding/FragmentNextBinding;)V", "language", "", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "nextAdapter", "Lcom/example/weatherapplication/ui/nextdays/NextAdapter;", "getNextAdapter", "()Lcom/example/weatherapplication/ui/nextdays/NextAdapter;", "setNextAdapter", "(Lcom/example/weatherapplication/ui/nextdays/NextAdapter;)V", "dailyobserveViewModel", "", "initViews", "lat", "", "lon", "exclude", "lang", "units", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onlineStoring", "app_debug"})
public final class NextFragment extends androidx.fragment.app.Fragment {
    public com.example.weatherapplication.databinding.FragmentNextBinding fragmentNextBinding;
    public com.example.weatherapplication.viewmodels.DailyViewModel dailyViewModel;
    public com.example.weatherapplication.ui.nextdays.NextAdapter nextAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String language = "en";
    
    public NextFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.weatherapplication.databinding.FragmentNextBinding getFragmentNextBinding() {
        return null;
    }
    
    public final void setFragmentNextBinding(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.databinding.FragmentNextBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.weatherapplication.viewmodels.DailyViewModel getDailyViewModel() {
        return null;
    }
    
    public final void setDailyViewModel(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.viewmodels.DailyViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.weatherapplication.ui.nextdays.NextAdapter getNextAdapter() {
        return null;
    }
    
    public final void setNextAdapter(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.ui.nextdays.NextAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    public final void setLanguage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    private final void initViews(double lat, double lon, java.lang.String exclude, java.lang.String lang, java.lang.String units) {
    }
    
    public final void onlineStoring() {
    }
    
    public final void dailyobserveViewModel() {
    }
}