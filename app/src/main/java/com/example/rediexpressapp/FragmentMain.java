package com.example.rediexpressapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.rediexpressapp.R.id;

import com.example.rediexpressapp.databinding.FragmentMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.jvm.internal.Intrinsics;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragmentMain extends Fragment {

    private FragmentMainBinding _binding;

    private final FragmentMainBinding getBinding() {
        FragmentMainBinding var10000 = this._binding;
        Intrinsics.checkNotNull(var10000);
        return var10000;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentMainBinding.inflate(inflater, container, false);
        FrameLayout var10000 = this.getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.root");
        FrameLayout view = var10000;
        return (View)view;
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context var10000 = this.getContext();
        SharedPreferences sharedPref = var10000 != null ? var10000.getSharedPreferences("deliveryProgramm", 0) : null;
        if (sharedPref != null) {
            boolean var4 = sharedPref.getBoolean("isLogIn", false);
            SharedPreferences.Editor var8 = sharedPref.edit();
            Intrinsics.checkNotNullExpressionValue(var8, "sharedPref.edit()");
            SharedPreferences.Editor editor = var8;
            editor.putBoolean("isLogIn", true);
            editor.commit();
            BottomNavigationView var9 = this.getBinding().bottomNavigationM;
            Intrinsics.checkNotNullExpressionValue(var9, "binding.bottomNavigationM");
            BottomNavigationView bottomNavigationView = var9;
            bottomNavigationView.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener)(new BottomNavigationView.OnNavigationItemSelectedListener() {
                public final boolean onNavigationItemSelected(@NotNull MenuItem item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    int var2 = item.getItemId();
                    if (var2 == id.navigation_home) {
                        FragmentMain.this.replaceFragment((Fragment)(new FragmentHome()));
                        return true;
                    } else if (var2 == id.navigation_wallet) {
                        FragmentMain.this.replaceFragment((Fragment)(new FragmentWallet()));
                        return true;
                    } else if (var2 == id.navigation_track) {
                        FragmentMain.this.replaceFragment((Fragment)(new FragmentTrack()));
                        return true;
                    } else if (var2 == id.navigation_profile) {
                        FragmentMain.this.replaceFragment((Fragment)(new FragmentProfile()));
                        return true;
                    } else {
                        return false;
                    }
                }
            }));
            bottomNavigationView.setSelectedItemId(id.navigation_home);
            Bundle var10 = this.getArguments();
            String profileSettingsSaved = var10 != null ? var10.getString("pageMain") : null;
            if (Intrinsics.areEqual(profileSettingsSaved, "profile")) {
                bottomNavigationView.setSelectedItemId(id.navigation_profile);
            }

            if (Intrinsics.areEqual(profileSettingsSaved, "track")) {
                bottomNavigationView.setSelectedItemId(id.navigation_track);
            }

            if (Intrinsics.areEqual(profileSettingsSaved, "home")) {
                bottomNavigationView.setSelectedItemId(id.navigation_home);
            }

            if (Intrinsics.areEqual(profileSettingsSaved, "wallet")) {
                bottomNavigationView.setSelectedItemId(id.navigation_wallet);
            }

        }
    }

    private final void replaceFragment(Fragment fragment) {
        this.getChildFragmentManager().beginTransaction().replace(id.fragment_containerM, fragment).commit();
    }

    // $FF: synthetic method
    public void onDestroyView() {
        super.onDestroyView();
    }
}