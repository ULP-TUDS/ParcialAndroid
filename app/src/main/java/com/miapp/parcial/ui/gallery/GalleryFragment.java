package com.miapp.parcial.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.miapp.parcial.databinding.FragmentGalleryBinding;
import com.miapp.parcial.modelo.Turismo;
import com.miapp.parcial.ui.slideshow.SlideshowViewModel;

import java.util.List;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private GalleryViewModel mv;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mv = new ViewModelProvider(this).get(GalleryViewModel.class);

        mv.getListaMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Turismo>>() {
            @Override
            public void onChanged(List<Turismo> turismos) {

                    TurismoAdapter adapter = new TurismoAdapter(turismos, requireContext(), getLayoutInflater());
                    RecyclerView rc = binding.lista;
                    rc.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
                    rc.setAdapter(adapter);
            }
        });

        mv.crearLista();

        return root;
    }
}
