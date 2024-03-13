package com.example.rediexpressapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.example.rediexpressapp.R.drawable;
import com.example.rediexpressapp.R.id;
import com.example.rediexpressapp.databinding.FragmentProfileBinding;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FragmentProfile extends Fragment {

    private FragmentProfileBinding _binding;
    private boolean isBalanceVisible = true;
    private float currentBalance = 30712.0F;

    private final FragmentProfileBinding getBinding() {
        FragmentProfileBinding var10000 = this._binding;
        Intrinsics.checkNotNull(var10000);
        return var10000;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentProfileBinding.inflate(inflater, container, false);
        ConstraintLayout var10000 = this.getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.root");
        ConstraintLayout view = var10000;
        return (View)view;
    }

    public final boolean isBalanceVisible() {
        return this.isBalanceVisible;
    }

    public final void setBalanceVisible(boolean var1) {
        this.isBalanceVisible = var1;
    }

    public final float getCurrentBalance() {
        return this.currentBalance;
    }

    public final void setCurrentBalance(float var1) {
        this.currentBalance = var1;
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final NavController controller = FragmentKt.findNavController(this);
       this.getBinding().fprofileBtnLogOut.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent i = new Intent(getContext(), MainActivitySignIn.class);
                startActivity(i);

            }
        }));
      this.getBinding().fprofileBtnCard.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                controller.navigate(id.fragmentAddPayMethod);
            }
        }));

         this.getBinding().fprofileBtnNotificSet.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                controller.navigate(id.fragmentNotification);
            }
        }));
        this.getBinding().fprofileBtnShowBalance.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                FragmentProfile.this.setBalanceVisible(!FragmentProfile.this.isBalanceVisible());
                TextView var10000;
                if (FragmentProfile.this.isBalanceVisible()) {
                    var10000 = FragmentProfile.this.getBinding().fprofileEtBalance;
                    Intrinsics.checkNotNullExpressionValue(var10000, "binding.fprofileEtBalance");
                    var10000.setText((CharSequence)FragmentProfile.this.formatBalance(FragmentProfile.this.getCurrentBalance()));
                } else {
                    var10000 = FragmentProfile.this.getBinding().fprofileEtBalance;
                    Intrinsics.checkNotNullExpressionValue(var10000, "binding.fprofileEtBalance");
                    var10000.setText((CharSequence)"**********");
                }

                int drawableRes = FragmentProfile.this.isBalanceVisible() ? drawable.img_eye : drawable.img_eye_slash;
                FragmentProfile.this.getBinding().fprofileBtnShowBalance.setImageResource(drawableRes);
            }
        }));
    }

    @NotNull
    public final String formatBalance(float balance) {
        DecimalFormat decimalFormat = new DecimalFormat("N##,###.00");
        String var10000 = decimalFormat.format(balance);
        Intrinsics.checkNotNullExpressionValue(var10000, "decimalFormat.format(balance)");
        return var10000;
    }

    // $FF: synthetic method
    public void onDestroyView() {
        super.onDestroyView();
    }
}