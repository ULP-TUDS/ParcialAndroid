    package com.miapp.parcial.ui.mapa;

    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.fragment.app.Fragment;
    import androidx.lifecycle.Observer;
    import androidx.lifecycle.ViewModelProvider;

    import android.location.Location;
    import android.os.Bundle;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import com.miapp.parcial.ui.slideshow.SlideshowViewModel;

    import com.google.android.gms.maps.CameraUpdateFactory;
    import com.google.android.gms.maps.GoogleMap;
    import com.google.android.gms.maps.OnMapReadyCallback;
    import com.google.android.gms.maps.SupportMapFragment;
    import com.google.android.gms.maps.model.LatLng;
    import com.google.android.gms.maps.model.MarkerOptions;
    import com.miapp.parcial.R;
    import com.miapp.parcial.databinding.FragmentMapsBinding;
    import com.miapp.parcial.ui.slideshow.SlideshowViewModel;

    public class MapsFragment extends Fragment {
      private SlideshowViewModel vm;
        private MapaViewModel mViewModel;
        private FragmentMapsBinding binding; // Declarar el binding
        private GoogleMap googleMap; // Almacenar una referencia al GoogleMap
        private static final LatLng LATITUD_PLAZA = new LatLng(-33.30207, -66.33697);
        private static final LatLng LATITUD_AUTODROMO = new LatLng(-33.33443, -66.39441);
        private static final LatLng LATITUD_PLAZAINDEPENCIA = new LatLng(-33.307512, -66.335657);
        private static final LatLng LATITUD_CABILDO = new LatLng(-33.29501, -66.33563);

        private OnMapReadyCallback callback = new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap map) {
                googleMap = map;
                mViewModel.lecturaPermanente();
            }
        };

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater,
                                 @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            // Inflar y retornar el layout utilizando View Binding
            binding = FragmentMapsBinding.inflate(inflater, container, false);
            return binding.getRoot();

        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            // Inicializa el ViewModel
            mViewModel = new ViewModelProvider(this).get(MapaViewModel.class);
            vm = new ViewModelProvider(requireActivity()).get(SlideshowViewModel.class);

            // Obtiene una instancia de SupportMapFragment
            SupportMapFragment mapFragment =
                    (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

            if (mapFragment != null) {
                // Obtiene el mapa de manera asíncrona
                mapFragment.getMapAsync(callback);
            }

            // Observa los cambios en la ubicación
            mViewModel.getMLocation().observe(getViewLifecycleOwner(), new Observer<Location>() {
                @Override
                public void onChanged(Location location) {
                    // Maneja la actualización de la ubicación aquí
                    if (location != null && googleMap != null) {
                        // Actualiza el mapa con la nueva ubicación
                        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                        googleMap.clear();
                        googleMap.addMarker(new MarkerOptions().position(latLng).title("Mi Ubicación"));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));
                        // Agrega marcador para ubicación estática
                        googleMap.addMarker(new MarkerOptions().position(LATITUD_PLAZA).title("Plaza Pringles"));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LATITUD_PLAZA, 13));

                        googleMap.addMarker(new MarkerOptions().position(LATITUD_AUTODROMO).title("Autodromo"));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LATITUD_AUTODROMO, 13));

                        googleMap.addMarker(new MarkerOptions().position(LATITUD_CABILDO).title("Casa De Tucuman"));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LATITUD_CABILDO, 13));

                        googleMap.addMarker(new MarkerOptions().position(LATITUD_PLAZAINDEPENCIA).title("Plaza Independencia"));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LATITUD_PLAZAINDEPENCIA, 13));

                        String tipoDeMapaSeleccionado = vm.getTipoMapa();
                        if (tipoDeMapaSeleccionado != null) {
                            // Establece el tipo de mapa según la selección
                            switch (tipoDeMapaSeleccionado) {
                                case "Normal":
                                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                                    break;
                                case "Satélite":
                                    googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                                    break;
                                case "Terreno":
                                    googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                                    break;
                                default:
                                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                                    break;
                            }
                        }

                    }
                }

            });


        }
        @Override
        public void onPause() {
            super.onPause();
            // Detener la observación del LiveData en onPause
                mViewModel.getMLocation().removeObservers(getViewLifecycleOwner());
        }
        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null; // Liberar la referencia al binding
        }
    }