package com.example.weatherapplication.data.local.favouriteroom;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/weatherapplication/data/local/favouriteroom/FavouriteDao;", "", "addLocation", "", "favEntity", "Lcom/example/weatherapplication/data/local/favouriteroom/FavouriteEntity;", "deleteAll", "deleteLocation", "getFavouriteLocation", "", "updateLocation", "app_debug"})
public abstract interface FavouriteDao {
    
    @androidx.room.Insert()
    public abstract void addLocation(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.data.local.favouriteroom.FavouriteEntity favEntity);
    
    @androidx.room.Delete()
    public abstract void deleteLocation(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.data.local.favouriteroom.FavouriteEntity favEntity);
    
    @androidx.room.Update()
    public abstract void updateLocation(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.data.local.favouriteroom.FavouriteEntity favEntity);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM favourite")
    public abstract java.util.List<com.example.weatherapplication.data.local.favouriteroom.FavouriteEntity> getFavouriteLocation();
    
    @androidx.room.Query(value = "DELETE FROM favourite")
    public abstract void deleteAll();
}