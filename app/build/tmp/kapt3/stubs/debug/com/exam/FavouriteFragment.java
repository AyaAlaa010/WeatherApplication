package com.exam;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\u001e\u001a\u00020\u001fJ\"\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020!2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J&\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00100\u001a\u00020!2\u0006\u0010\'\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u00061"}, d2 = {"Lcom/exam/FavouriteFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "ERROR_DIALOG_REQUEST", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "favouritArray", "Ljava/util/ArrayList;", "Lcom/example/weatherapplication/data/local/favouriteroom/FavouriteEntity;", "Lkotlin/collections/ArrayList;", "getFavouritArray", "()Ljava/util/ArrayList;", "setFavouritArray", "(Ljava/util/ArrayList;)V", "favouriteAdapter", "Lcom/example/weatherapplication/ui/favourit/FavouriteAdapter;", "getFavouriteAdapter", "()Lcom/example/weatherapplication/ui/favourit/FavouriteAdapter;", "setFavouriteAdapter", "(Lcom/example/weatherapplication/ui/favourit/FavouriteAdapter;)V", "fragmentFavouriteBinding", "Lcom/example/weatherapplication/databinding/FragmentFavouriteBinding;", "getFragmentFavouriteBinding", "()Lcom/example/weatherapplication/databinding/FragmentFavouriteBinding;", "setFragmentFavouriteBinding", "(Lcom/example/weatherapplication/databinding/FragmentFavouriteBinding;)V", "isServicesOK", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "app_debug"})
public final class FavouriteFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    public com.example.weatherapplication.databinding.FragmentFavouriteBinding fragmentFavouriteBinding;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.example.weatherapplication.data.local.favouriteroom.FavouriteEntity> favouritArray;
    public com.example.weatherapplication.ui.favourit.FavouriteAdapter favouriteAdapter;
    private final int ERROR_DIALOG_REQUEST = 9001;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "Favourit fragment";
    
    public FavouriteFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.weatherapplication.databinding.FragmentFavouriteBinding getFragmentFavouriteBinding() {
        return null;
    }
    
    public final void setFragmentFavouriteBinding(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.databinding.FragmentFavouriteBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.weatherapplication.data.local.favouriteroom.FavouriteEntity> getFavouritArray() {
        return null;
    }
    
    public final void setFavouritArray(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.weatherapplication.data.local.favouriteroom.FavouriteEntity> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.weatherapplication.ui.favourit.FavouriteAdapter getFavouriteAdapter() {
        return null;
    }
    
    public final void setFavouriteAdapter(@org.jetbrains.annotations.NotNull()
    com.example.weatherapplication.ui.favourit.FavouriteAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
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
    
    public final boolean isServicesOK() {
        return false;
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
}