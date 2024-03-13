package com.example.rediexpressapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.example.rediexpressapp.R.drawable;
import com.example.rediexpressapp.databinding.FragmentWalletBinding;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class FragmentWallet extends Fragment {

    private FragmentWalletBinding _binding;
    private boolean isBalanceVisible = true;
    private float currentBalance = 30712.0F;

    private final FragmentWalletBinding getBinding() {
        FragmentWalletBinding var10000 = this._binding;
        Intrinsics.checkNotNull(var10000);
        return var10000;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentWalletBinding.inflate(inflater, container, false);
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
        this.getBinding().fwalletBtnShowBalance.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                FragmentWallet.this.setBalanceVisible(!FragmentWallet.this.isBalanceVisible());
                TextView var10000;
                if (FragmentWallet.this.isBalanceVisible()) {
                    var10000 = FragmentWallet.this.getBinding().fwalletEtBalance;
                    Intrinsics.checkNotNullExpressionValue(var10000, "binding.fwalletEtBalance");
                    var10000.setText((CharSequence)FragmentWallet.this.formatBalance(FragmentWallet.this.getCurrentBalance()));
                } else {
                    var10000 = FragmentWallet.this.getBinding().fwalletEtBalance;
                    Intrinsics.checkNotNullExpressionValue(var10000, "binding.fwalletEtBalance");
                    var10000.setText((CharSequence)"**********");
                }

                int drawableRes = FragmentWallet.this.isBalanceVisible() ? drawable.img_eye : drawable.img_eye_slash;
                FragmentWallet.this.getBinding().fwalletBtnShowBalance.setImageResource(drawableRes);
            }
        }));
    }

    @NotNull
    public final String formatBalance(float balance) {
        DecimalFormat decimalFormat = new DecimalFormat("N###,###.00");
        String var10000 = decimalFormat.format(balance);
        Intrinsics.checkNotNullExpressionValue(var10000, "decimalFormat.format(balance)");
        return var10000;
    }

    // $FF: synthetic method
    public void onDestroyView() {
        super.onDestroyView();
    }
}