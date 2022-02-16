package com.example.weatherapplication;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.weatherapplication.databinding.ActivityMainBindingImpl;
import com.example.weatherapplication.databinding.ActivityMapTestBindingImpl;
import com.example.weatherapplication.databinding.ActivitySetBindingImpl;
import com.example.weatherapplication.databinding.ActivitySettingsBindingImpl;
import com.example.weatherapplication.databinding.ActivitySplashScreenBindingImpl;
import com.example.weatherapplication.databinding.FavouriteDetailsBindingImpl;
import com.example.weatherapplication.databinding.FragmentCurrentBindingImpl;
import com.example.weatherapplication.databinding.FragmentFavouriteBindingImpl;
import com.example.weatherapplication.databinding.FragmentNextBindingImpl;
import com.example.weatherapplication.databinding.HeaderNavBindingImpl;
import com.example.weatherapplication.databinding.ItemCurrentHoursBindingImpl;
import com.example.weatherapplication.databinding.ItemFavouriteBindingImpl;
import com.example.weatherapplication.databinding.ItemNextBindingImpl;
import com.example.weatherapplication.databinding.TestSettingBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_ACTIVITYMAPTEST = 2;

  private static final int LAYOUT_ACTIVITYSET = 3;

  private static final int LAYOUT_ACTIVITYSETTINGS = 4;

  private static final int LAYOUT_ACTIVITYSPLASHSCREEN = 5;

  private static final int LAYOUT_FAVOURITEDETAILS = 6;

  private static final int LAYOUT_FRAGMENTCURRENT = 7;

  private static final int LAYOUT_FRAGMENTFAVOURITE = 8;

  private static final int LAYOUT_FRAGMENTNEXT = 9;

  private static final int LAYOUT_HEADERNAV = 10;

  private static final int LAYOUT_ITEMCURRENTHOURS = 11;

  private static final int LAYOUT_ITEMFAVOURITE = 12;

  private static final int LAYOUT_ITEMNEXT = 13;

  private static final int LAYOUT_TESTSETTING = 14;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(14);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.activity_map_test, LAYOUT_ACTIVITYMAPTEST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.activity_set, LAYOUT_ACTIVITYSET);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.activity_settings, LAYOUT_ACTIVITYSETTINGS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.activity_splash_screen, LAYOUT_ACTIVITYSPLASHSCREEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.favourite_details, LAYOUT_FAVOURITEDETAILS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.fragment_current, LAYOUT_FRAGMENTCURRENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.fragment_favourite, LAYOUT_FRAGMENTFAVOURITE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.fragment_next, LAYOUT_FRAGMENTNEXT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.header_nav, LAYOUT_HEADERNAV);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.item_current_hours, LAYOUT_ITEMCURRENTHOURS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.item_favourite, LAYOUT_ITEMFAVOURITE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.item_next, LAYOUT_ITEMNEXT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.weatherapplication.R.layout.test_setting, LAYOUT_TESTSETTING);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAPTEST: {
          if ("layout/activity_map_test_0".equals(tag)) {
            return new ActivityMapTestBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_map_test is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSET: {
          if ("layout/activity_set_0".equals(tag)) {
            return new ActivitySetBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_set is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSETTINGS: {
          if ("layout/activity_settings_0".equals(tag)) {
            return new ActivitySettingsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_settings is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSPLASHSCREEN: {
          if ("layout/activity_splash_screen_0".equals(tag)) {
            return new ActivitySplashScreenBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_splash_screen is invalid. Received: " + tag);
        }
        case  LAYOUT_FAVOURITEDETAILS: {
          if ("layout/favourite_details_0".equals(tag)) {
            return new FavouriteDetailsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for favourite_details is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCURRENT: {
          if ("layout/fragment_current_0".equals(tag)) {
            return new FragmentCurrentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_current is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFAVOURITE: {
          if ("layout/fragment_favourite_0".equals(tag)) {
            return new FragmentFavouriteBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_favourite is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTNEXT: {
          if ("layout/fragment_next_0".equals(tag)) {
            return new FragmentNextBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_next is invalid. Received: " + tag);
        }
        case  LAYOUT_HEADERNAV: {
          if ("layout/header_nav_0".equals(tag)) {
            return new HeaderNavBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for header_nav is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMCURRENTHOURS: {
          if ("layout/item_current_hours_0".equals(tag)) {
            return new ItemCurrentHoursBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_current_hours is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMFAVOURITE: {
          if ("layout/item_favourite_0".equals(tag)) {
            return new ItemFavouriteBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_favourite is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMNEXT: {
          if ("layout/item_next_0".equals(tag)) {
            return new ItemNextBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_next is invalid. Received: " + tag);
        }
        case  LAYOUT_TESTSETTING: {
          if ("layout/test_setting_0".equals(tag)) {
            return new TestSettingBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for test_setting is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(14);

    static {
      sKeys.put("layout/activity_main_0", com.example.weatherapplication.R.layout.activity_main);
      sKeys.put("layout/activity_map_test_0", com.example.weatherapplication.R.layout.activity_map_test);
      sKeys.put("layout/activity_set_0", com.example.weatherapplication.R.layout.activity_set);
      sKeys.put("layout/activity_settings_0", com.example.weatherapplication.R.layout.activity_settings);
      sKeys.put("layout/activity_splash_screen_0", com.example.weatherapplication.R.layout.activity_splash_screen);
      sKeys.put("layout/favourite_details_0", com.example.weatherapplication.R.layout.favourite_details);
      sKeys.put("layout/fragment_current_0", com.example.weatherapplication.R.layout.fragment_current);
      sKeys.put("layout/fragment_favourite_0", com.example.weatherapplication.R.layout.fragment_favourite);
      sKeys.put("layout/fragment_next_0", com.example.weatherapplication.R.layout.fragment_next);
      sKeys.put("layout/header_nav_0", com.example.weatherapplication.R.layout.header_nav);
      sKeys.put("layout/item_current_hours_0", com.example.weatherapplication.R.layout.item_current_hours);
      sKeys.put("layout/item_favourite_0", com.example.weatherapplication.R.layout.item_favourite);
      sKeys.put("layout/item_next_0", com.example.weatherapplication.R.layout.item_next);
      sKeys.put("layout/test_setting_0", com.example.weatherapplication.R.layout.test_setting);
    }
  }
}
