package com.miapp.parcial.ui.gallery;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.miapp.parcial.R;
import com.miapp.parcial.modelo.Turismo;

import java.util.ArrayList;
import java.util.List;

public class GalleryViewModel extends AndroidViewModel {

    private MutableLiveData<List<Turismo>> listaMutableLiveData;


    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<Turismo>> getListaMutableLiveData() {
        if (listaMutableLiveData == null) {
            listaMutableLiveData=new MutableLiveData<>();
        }
        return listaMutableLiveData;
    }
    public void crearLista() {
        ArrayList<Turismo> lista = new ArrayList<>();
        int[] imagenesPlaza = {R.drawable.plaza1, R.drawable.plaza2};
        int[] imagenesIndependencia = {R.drawable.independencia1, R.drawable.independencia2};
        int[] imagenesRosendo = {R.drawable.autodromo1, R.drawable.autodromo2};

        int[] imagenesTucuman = {R.drawable.tucuman1, R.drawable.tucuman2};

        lista.add(new Turismo("Plaza Pringles", "Esta en el Corazón de San Luis, un lugar muy visitado debido a su cercanía con la estatua de San Martín.", imagenesPlaza, "Horario: Las 24 horas"));
        lista.add(new Turismo("Plaza Independencia ", "Ubicada en San Luis, es un punto de encuentro común para los residentes locales.", imagenesIndependencia, "Horario: De 9:00 AM a 7:00 PM"));
        lista.add(new Turismo("Autódromo Rosendo Hernández San Luis", "Un circuito de carreras famoso por albergar varios eventos automovilísticos importantes.", imagenesRosendo, "Horario: Consultar eventos programados"));
        lista.add(new Turismo("Plaza de Tucumán San Luis", "Una hermosa plaza que rinde homenaje a la ciudad de Tucumán, Argentina.",imagenesTucuman, "Horario: De 8:00 AM a 10:00 PM"));

        listaMutableLiveData.setValue(lista);
    }
}