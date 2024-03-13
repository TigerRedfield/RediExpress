package com.example.rediexpressapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.example.rediexpressapp.R.id;
import com.example.rediexpressapp.databinding.FragmentChatBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FragmentChat extends Fragment {

    private FragmentChatBinding _binding;

    private final FragmentChatBinding getBinding() {
        FragmentChatBinding var10000 = this._binding;
        Intrinsics.checkNotNull(var10000);
        return var10000;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentChatBinding.inflate(inflater, container, false);
        RelativeLayout var10000 = this.getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(var10000, "binding.root");
        RelativeLayout view = var10000;
        return (View)view;
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final NavController controller = FragmentKt.findNavController(this);
        this.getBinding().fchatBtnBack.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                controller.navigate(id.fragmentChats);
            }
        }));
        this.getBinding().fchatBtnCall.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                controller.navigate(id.fragmentCalling);
            }
        }));
    }

    // $FF: synthetic method
    public void onDestroyView() {
        super.onDestroyView();
    }
}