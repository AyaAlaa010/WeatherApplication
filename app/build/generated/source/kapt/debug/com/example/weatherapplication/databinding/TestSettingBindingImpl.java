package com.example.weatherapplication.databinding;
import com.example.weatherapplication.R;
import com.example.weatherapplication.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class TestSettingBindingImpl extends TestSettingBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tv_location, 1);
        sViewsWithIds.put(R.id.toggel_gps, 2);
        sViewsWithIds.put(R.id.tv_map, 3);
        sViewsWithIds.put(R.id.tv_language, 4);
        sViewsWithIds.put(R.id.togge_arabic, 5);
        sViewsWithIds.put(R.id.toggel_english, 6);
        sViewsWithIds.put(R.id.tv_tempreture, 7);
        sViewsWithIds.put(R.id.radioGroup, 8);
        sViewsWithIds.put(R.id.togge_degree_celsius, 9);
        sViewsWithIds.put(R.id.toggel_Kelvin, 10);
        sViewsWithIds.put(R.id.toggel_Fahrenheit, 11);
        sViewsWithIds.put(R.id.tv_wind_speed, 12);
        sViewsWithIds.put(R.id.togge_wind_ms, 13);
        sViewsWithIds.put(R.id.toggel_milehour, 14);
        sViewsWithIds.put(R.id.tv_notifications, 15);
        sViewsWithIds.put(R.id.togge_notify_enable, 16);
        sViewsWithIds.put(R.id.toggel_notify_disable, 17);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public TestSettingBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }
    private TestSettingBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.RadioGroup) bindings[8]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[5]
            , (android.widget.RadioButton) bindings[9]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[16]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[13]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[6]
            , (android.widget.RadioButton) bindings[11]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[2]
            , (android.widget.RadioButton) bindings[10]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[14]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[17]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[1]
            , (com.google.android.material.switchmaterial.SwitchMaterial) bindings[3]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[12]
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