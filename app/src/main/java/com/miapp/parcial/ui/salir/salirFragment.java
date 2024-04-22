package com.miapp.parcial.ui.salir;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miapp.parcial.R;
import com.miapp.parcial.databinding.FragmentGalleryBinding;
import com.miapp.parcial.databinding.FragmentSalirBinding;


public class salirFragment extends Fragment {

    private FragmentSalirBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);

            }
        });

        return root;
    }


}