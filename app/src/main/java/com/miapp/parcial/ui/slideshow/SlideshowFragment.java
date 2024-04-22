package com.miapp.parcial.ui.slideshow;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.miapp.parcial.R;

import java.util.Locale;

public class SlideshowFragment extends Fragment {
    private SlideshowViewModel vm;
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        Button btnSpanish = root.findViewById(R.id.btespanol);
        Button btnEnglish = root.findViewById(R.id.btin);

        vm = new ViewModelProvider(requireActivity()).get(SlideshowViewModel.class);
        spinner = root.findViewById(R.id.spinnerTipoMapa);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.tipoMapa));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (vm != null) {
                    vm.setTipoMapa(parent.getItemAtPosition(position).toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se hace nada en este caso
            }
        });



        btnSpanish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                setLocale("es");
            }
        });

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("en");
            }
        });

        return root;
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Reinicia la actividad para aplicar los cambios de idioma
        getActivity().recreate();
    }
}
