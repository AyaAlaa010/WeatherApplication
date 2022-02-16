package com.example.weatherapplication.data.local.current;

import java.lang.System;

@androidx.room.Entity(tableName = "myCurrent")
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b \b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001e\u0010\'\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000e\u00a8\u0006*"}, d2 = {"Lcom/example/weatherapplication/data/local/current/CurrentEntity;", "", "()V", "currentAddress", "", "getCurrentAddress", "()Ljava/lang/String;", "setCurrentAddress", "(Ljava/lang/String;)V", "currentCloud", "", "getCurrentCloud", "()I", "setCurrentCloud", "(I)V", "currentDate", "getCurrentDate", "setCurrentDate", "currentDescription", "getCurrentDescription", "setCurrentDescription", "currentHumedity", "getCurrentHumedity", "setCurrentHumedity", "currentIcon", "getCurrentIcon", "setCurrentIcon", "currentPressure", "getCurrentPressure", "setCurrentPressure", "currentTemp", "getCurrentTemp", "setCurrentTemp", "currentWind", "getCurrentWind", "setCurrentWind", "id", "getId", "setId", "key", "getKey", "setKey", "app_debug"})
public final class CurrentEntity {
    @androidx.room.ColumnInfo(name = "id")
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id = 0;
    @androidx.room.ColumnInfo(name = "key")
    private int key = 0;
    @androidx.room.ColumnInfo(name = "currentAddress")
    public java.lang.String currentAddress;
    @androidx.room.ColumnInfo(name = "currentDate")
    public java.lang.String currentDate;
    @androidx.room.ColumnInfo(name = "currentDescription")
    public java.lang.String currentDescription;
    @androidx.room.ColumnInfo(name = "currentTemp")
    public java.lang.String currentTemp;
    @androidx.room.ColumnInfo(name = "currentPressure")
    private int currentPressure = 0;
    @androidx.room.ColumnInfo(name = "currentHumedity")
    private int currentHumedity = 0;
    @androidx.room.ColumnInfo(name = "currentWind")
    public java.lang.String currentWind;
    @androidx.room.ColumnInfo(name = "currentCloud")
    private int currentCloud = 0;
    @androidx.room.ColumnInfo(name = "currentIcon")
    public java.lang.String currentIcon;
    
    public CurrentEntity() {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    public final int getKey() {
        return 0;
    }
    
    public final void setKey(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentAddress() {
        return null;
    }
    
    public final void setCurrentAddress(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentDate() {
        return null;
    }
    
    public final void setCurrentDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentDescription() {
        return null;
    }
    
    public final void setCurrentDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentTemp() {
        return null;
    }
    
    public final void setCurrentTemp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getCurrentPressure() {
        return 0;
    }
    
    public final void setCurrentPressure(int p0) {
    }
    
    public final int getCurrentHumedity() {
        return 0;
    }
    
    public final void setCurrentHumedity(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentWind() {
        return null;
    }
    
    public final void setCurrentWind(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getCurrentCloud() {
        return 0;
    }
    
    public final void setCurrentCloud(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentIcon() {
        return null;
    }
    
    public final void setCurrentIcon(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
}