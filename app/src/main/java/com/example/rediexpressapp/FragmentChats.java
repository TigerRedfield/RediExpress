package com.example.rediexpressapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.example.rediexpressapp.R.id;
import com.example.rediexpressapp.databinding.FragmentChatsBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FragmentChats extends Fragment {

    private FragmentChatsBinding _binding;

    private final FragmentChatsBinding getBinding() {
        FragmentChatsBinding var10000 = this._binding;
        Intrinsics.checkNotNull(var10000);
        return var10000;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentChatsBinding.inflate(inflater, container, false);
        ConstraintLayout var10000 = this.getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.root");
        ConstraintLayout view = var10000;
        return (View)view;
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final NavController controller = FragmentKt.findNavController(this);
        this.getBinding().fchatsBtnBack.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                controller.navigate(id.fragmentMain);
            }
        }));
        this.getBinding().fchatsChat1.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                controller.navigate(id.fragmentChat);
            }
        }));
    }

    // $FF: synthetic method
    public void onDestroyView() {
        super.onDestroyView();
    }
}