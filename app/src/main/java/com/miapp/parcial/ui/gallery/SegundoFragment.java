    package com.miapp.parcial.ui.gallery;

    import android.os.Bundle;

    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.fragment.app.Fragment;
    import androidx.lifecycle.Observer;
    import androidx.lifecycle.ViewModelProvider;

    import android.util.Log;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageView;
    import android.widget.TextView;

    import com.miapp.parcial.R;
    import com.miapp.parcial.databinding.FragmentGalleryBinding;
    import com.miapp.parcial.databinding.FragmentSegundoBinding;
    import com.miapp.parcial.modelo.Turismo;

    /**
     * A simple {@link Fragment} subclass.
     * Use the factory method to
     * create an instance of this fragment.
     */

    public class SegundoFragment extends Fragment {
        SegundoViewModel vm;
        FragmentSegundoBinding binding;

        public static SegundoFragment newInstance() {
            return new SegundoFragment();
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            binding = FragmentSegundoBinding.inflate(inflater, container, false);
            View root = binding.getRoot();

            vm = new ViewModelProvider(this).get(SegundoViewModel.class);

            vm.getTurismoM().observe(getViewLifecycleOwner(), new Observer<Turismo>() {
                @Override
                public void onChanged(Turismo turismo) {
                    binding.txnombre.setText(turismo.getNombre());
                    binding.tvhorario.setText(turismo.getHorario());
                    if (turismo.getFotos() != null && turismo.getFotos().length > 0) {
                        binding.foto1.setImageResource(turismo.getFotos()[0]);
                        // Si solo tienes una imagen, asegúrate de que solo estableces la primera imagen.
                        if (turismo.getFotos().length > 1) {
                            binding.foto2.setImageResource(turismo.getFotos()[1]);
                        }
                    }
                }
            });

            vm.getMutableImagen().observe(getViewLifecycleOwner(), new Observer<Integer>() {
                @Override
                public void onChanged(Integer integer) {
                    // No estoy seguro de dónde debería mostrarse esta imagen, así que la he dejado como comentario.
                    // binding.foto1.setImageResource(integer);
                }
            });

            vm.recuperarTurismo(getArguments());

            return root;
        }
    }
