package com.example.rediexpressapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.example.rediexpressapp.R.id;
import com.example.rediexpressapp.databinding.FragmentSendPackageBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class FragmentSendPackage extends Fragment {

    private FragmentSendPackageBinding _binding;
    private int cntDestDetails = 1;

    private final FragmentSendPackageBinding getBinding() {
        FragmentSendPackageBinding var10000 = this._binding;
        Intrinsics.checkNotNull(var10000);
        return var10000;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentSendPackageBinding.inflate(inflater, container, false);
        ConstraintLayout var10000 = this.getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.root");
        ConstraintLayout view = var10000;
        return (View)view;
    }

    public final int getCntDestDetails() {
        return this.cntDestDetails;
    }

    public final void setCntDestDetails(int var1) {
        this.cntDestDetails = var1;
    }

    public void onViewCreated(@NotNull final View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final NavController controller = FragmentKt.findNavController(this);
        this.getBinding().fsendpackBtnBack.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                controller.navigate(id.fragmentMain);
            }
        }));
        this.getBinding().fsendpackBtnNext.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                FragmentSendPackage.this.nextClick(view);
            }
        }));
        this.getBinding().fsendpackBtnEditPackage.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                FragmentSendPackage.this.editPackageClick(view);
            }
        }));
        this.getBinding().fsendpackBtnMakePayment.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                FragmentSendPackage.this.makePaymentClick(view);
            }
        }));
        this.getBinding().fsendpackBtnAddDestin.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                LinearLayout var10000;
                if (FragmentSendPackage.this.getCntDestDetails() == 4) {
                    var10000 = FragmentSendPackage.this.getBinding().fsendpackBtnAddDestin;
                    Intrinsics.checkNotNullExpressionValue(var10000, "binding.fsendpackBtnAddDestin");
                    var10000.setVisibility(8);
                }

                if (FragmentSendPackage.this.getCntDestDetails() < 5) {
                    FragmentSendPackage var3 = FragmentSendPackage.this;
                    var3.setCntDestDetails(var3.getCntDestDetails() + 1);
                    switch (FragmentSendPackage.this.getCntDestDetails()) {
                        case 2:
                            var10000 = FragmentSendPackage.this.getBinding().fsendpackLlDestDetail1;
                            Intrinsics.checkNotNullExpressionValue(var10000, "binding.fsendpackLlDestDetail1");
                            var10000.setVisibility(0);
                            break;
                        case 3:
                            var10000 = FragmentSendPackage.this.getBinding().fsendpackLlDestDetail2;
                            Intrinsics.checkNotNullExpressionValue(var10000, "binding.fsendpackLlDestDetail2");
                            var10000.setVisibility(0);
                            break;
                        case 4:
                            var10000 = FragmentSendPackage.this.getBinding().fsendpackLlDestDetail3;
                            Intrinsics.checkNotNullExpressionValue(var10000, "binding.fsendpackLlDestDetail3");
                            var10000.setVisibility(0);
                            break;
                        case 5:
                            var10000 = FragmentSendPackage.this.getBinding().fsendpackLlDestDetail4;
                            Intrinsics.checkNotNullExpressionValue(var10000, "binding.fsendpackLlDestDetail4");
                            var10000.setVisibility(0);
                    }
                }

            }
        }));
        this.editPackageClick(view);
    }

    public final void nextClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ScrollView var10000 = this.getBinding().fsendpackSvInputData;
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.fsendpackSvInputData");
        var10000.setVisibility(8);
        var10000 = this.getBinding().fsendpackSvOutputData;
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.fsendpackSvOutputData");
        var10000.setVisibility(0);
    }

    public final void editPackageClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ScrollView var10000 = this.getBinding().fsendpackSvInputData;
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.fsendpackSvInputData");
        var10000.setVisibility(0);
        var10000 = this.getBinding().fsendpackSvOutputData;
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.fsendpackSvOutputData");
        var10000.setVisibility(8);
    }

    public final void makePaymentClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        NavController controller = FragmentKt.findNavController(this);
        controller.navigate(id.fragmentTransaction);
    }

    // $FF: synthetic method
    public void onDestroyView() {
        super.onDestroyView();
    }

}