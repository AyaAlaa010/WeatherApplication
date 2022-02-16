package com.example.weatherapplication.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/example/weatherapplication/viewmodels/HourlyViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "repo", "Lcom/example/weatherapplication/repo/WeatherRepo;", "weatherLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/example/AllResponse;", "getWeatherLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setWeatherLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "getWeather", "", "lat", "", "lon", "exclude", "", "lang", "unites", "app_debug"})
public final class HourlyViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.example.example.AllResponse> weatherLiveData;
    private final com.example.weatherapplication.repo.WeatherRepo repo = null;
    
    public HourlyViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.example.AllResponse> getWeatherLiveData() {
        return null;
    }
    
    public final void setWeatherLiveData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.example.example.AllResponse> p0) {
    }
    
    public final void getWeather(double lat, double lon, @org.jetbrains.annotations.NotNull()
    java.lang.String exclude, @org.jetbrains.annotations.NotNull()
    java.lang.String lang, @org.jetbrains.annotations.NotNull()
    java.lang.String unites) {
    }
}