package com.example.weatherapplication.data.local.current;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\n"}, d2 = {"Lcom/example/weatherapplication/data/local/current/CurrentDao;", "", "addLocation", "", "currentEntity", "Lcom/example/weatherapplication/data/local/current/CurrentEntity;", "deleteAll", "getCurrentLocation", "", "updateCurrentLocation", "app_debug"})
public abstract interface CurrentDao {
    
    @androidx.room.Insert()
    public abstract void addLocation(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.data.local.current.CurrentEntity currentEntity);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM myCurrent")
    public abstract java.util.List<com.example.weatherapplication.data.local.current.CurrentEntity> getCurrentLocation();
    
    @androidx.room.Update()
    public abstract void updateCurrentLocation(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.data.local.current.CurrentEntity currentEntity);
    
    @androidx.room.Query(value = "DELETE FROM myCurrent")
    public abstract void deleteAll();
}