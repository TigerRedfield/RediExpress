package com.example.rediexpressapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.example.rediexpressapp.R.id;
import com.example.rediexpressapp.databinding.FragmentAddPayMethodBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;



public class FragmentAddPayMethod extends Fragment {

    private FragmentAddPayMethodBinding _binding;
    private int cntCards = 2;

    private final FragmentAddPayMethodBinding getBinding() {
        FragmentAddPayMethodBinding var10000 = this._binding;
        Intrinsics.checkNotNull(var10000);
        return var10000;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentAddPayMethodBinding.inflate(inflater, container, false);
        ConstraintLayout var10000 = this.getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.root");
        ConstraintLayout view = var10000;
        return (View)view;
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final NavController controller = FragmentKt.findNavController(this);
        final Bundle bundle = new Bundle();
        this.getBinding().faddpaymetBtnBack.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                bundle.putString("pageMain", "profile");
                controller.navigate(id.fragmentMain, bundle);
            }
        }));
        this.getBinding().faddpayBtnWithCard.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                FragmentAddPayMethod.this.setWithCard();
            }
        }));
        this.getBinding().faddpayRbWithCard.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                FragmentAddPayMethod.this.setWithCard();
            }
        }));
        this.getBinding().faddpayBtnWithWallet.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                FragmentAddPayMethod.this.setWithWallet();
            }
        }));
        this.getBinding().faddpayRbWithWallet.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                FragmentAddPayMethod.this.setWithWallet();
            }
        }));
        this.setWithWallet();
    }

    public final void setWithWallet() {
        RadioButton var10000 = this.getBinding().faddpayRbWithCard;
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.faddpayRbWithCard");
        var10000.setChecked(false);
        var10000 = this.getBinding().faddpayRbWithWallet;
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.faddpayRbWithWallet");
        var10000.setChecked(true);
        ConstraintLayout var3 = this.getBinding().faddpayBtnWithCard;
        Intrinsics.checkNotNullExpressionValue(var3, "binding.faddpayBtnWithCard");
        ConstraintLayout constraintLayout = var3;
        ViewGroup.LayoutParams var4 = constraintLayout.getLayoutParams();
        if (var4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        } else {
            ViewGroup.LayoutParams layoutParams = var4;
            layoutParams.height = this.dpToPx(96);
            constraintLayout.setLayoutParams(layoutParams);
        }
    }

    public final int getCntCards() {
        return this.cntCards;
    }

    public final void setCntCards(int var1) {
        this.cntCards = var1;
    }

    public final void setWithCard() {
        RadioButton var10000 = this.getBinding().faddpayRbWithCard;
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.faddpayRbWithCard");
        var10000.setChecked(true);
        var10000 = this.getBinding().faddpayRbWithWallet;
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.faddpayRbWithWallet");
        var10000.setChecked(false);
        ConstraintLayout var3 = this.getBinding().faddpayBtnWithCard;
        Intrinsics.checkNotNullExpressionValue(var3, "binding.faddpayBtnWithCard");
        ConstraintLayout constraintLayout = var3;
        ViewGroup.LayoutParams var4 = constraintLayout.getLayoutParams();
        if (var4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        } else {
            ViewGroup.LayoutParams layoutParams = var4;
            layoutParams.height = this.dpToPx(64 + this.cntCards * 72 + 32);
            constraintLayout.setLayoutParams(layoutParams);
        }
    }

    public final int dpToPx(int dp) {
        Resources var10000 = this.getResources();
        Intrinsics.checkNotNullExpressionValue(var10000, "resources");
        float scale = var10000.getDisplayMetrics().density;
        return (int)((float)dp * scale + 0.5F);
    }

    // $FF: synthetic method
    public void onDestroyView() {
        super.onDestroyView();
    }
}