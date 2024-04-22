package com.miapp.parcial.ui.slideshow;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.Closeable;

public class SlideshowViewModel extends ViewModel {

private String tipoMapa;

   public void setTipoMapa(String tipoMapa){

       this.tipoMapa=tipoMapa;
   }

    public String getTipoMapa() {
        return tipoMapa;
    }
}