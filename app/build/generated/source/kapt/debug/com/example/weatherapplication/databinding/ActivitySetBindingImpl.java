package com.example.weatherapplication.databinding;
import com.example.weatherapplication.R;
import com.example.weatherapplication.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySetBindingImpl extends ActivitySetBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.card_temp, 1);
        sViewsWithIds.put(R.id.tv_tempreture, 2);
        sViewsWithIds.put(R.id.card_group_temp, 3);
        sViewsWithIds.put(R.id.radioGroupp, 4);
        sViewsWithIds.put(R.id.togge_degree_celsiuss, 5);
        sViewsWithIds.put(R.id.toggel_Kelvinn, 6);
        sViewsWithIds.put(R.id.toggel_Fahrenheitt, 7);
        sViewsWithIds.put(R.id.card_wind, 8);
        sViewsWithIds.put(R.id.tv_wind_speed, 9);
        sViewsWithIds.put(R.id.card_groub_wind, 10);
        sViewsWithIds.put(R.id.radioGroup_wind, 11);
        sViewsWithIds.put(R.id.togge_ms, 12);
        sViewsWithIds.put(R.id.toggel_mh, 13);
        sViewsWithIds.put(R.id.card_location, 14);
        sViewsWithIds.put(R.id.tv_location, 15);
        sViewsWithIds.put(R.id.card_location_for_radio, 16);
        sViewsWithIds.put(R.id.radioGroup_location, 17);
        sViewsWithIds.put(R.id.togge_map, 18);
        sViewsWithIds.put(R.id.toggel_gps, 19);
        sViewsWithIds.put(R.id.card_notifications, 20);
        sViewsWithIds.put(R.id.tv_notifications, 21);
        sViewsWithIds.put(R.id.radioGroup_notifications, 22);
        sViewsWithIds.put(R.id.togge_notifications_on, 23);
        sViewsWithIds.put(R.id.toggel_notifications_off, 24);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySetBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }
    private ActivitySetBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.cardview.widget.CardView) bindings[10]
            , (androidx.cardview.widget.CardView) bindings[3]
            , (com.google.android.material.card.MaterialCardView) bindings[14]
            , (androidx.cardview.widget.CardView) bindings[16]
            , (com.google.android.material.card.MaterialCardView) bindings[20]
            , (com.google.android.material.card.MaterialCardView) bindings[1]
            , (com.google.android.material.card.MaterialCardView) bindings[8]
            , (android.widget.RadioGroup) bindings[17]
            , (android.widget.RadioGroup) bindings[22]
            , (android.widget.RadioGroup) bindings[11]
            , (android.widget.RadioGroup) bindings[4]
            , (android.widget.RadioButton) bindings[5]
            , (android.widget.RadioButton) bindings[18]
            , (android.widget.RadioButton) bindings[12]
            , (android.widget.RadioButton) bindings[23]
            , (android.widget.RadioButton) bindings[7]
            , (android.widget.RadioButton) bindings[19]
            , (android.widget.RadioButton) bindings[6]
            , (android.widget.RadioButton) bindings[13]
            , (android.widget.RadioButton) bindings[24]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[9]
            );
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}