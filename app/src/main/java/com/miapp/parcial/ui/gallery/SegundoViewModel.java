package com.miapp.parcial.ui.gallery;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.miapp.parcial.modelo.Turismo;

import java.util.List;


public class SegundoViewModel extends AndroidViewModel {
    private MutableLiveData<Turismo> turismoM;
    private MutableLiveData<Integer> mutableImagen;
    private int i;

    public SegundoViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<Turismo> getTurismoM() {

        if (turismoM==null){
            turismoM=new MutableLiveData<>();
        }
        return turismoM;
    }
    public LiveData<Integer> getMutableImagen(){
        if(mutableImagen==null){
            mutableImagen=new MutableLiveData<>();
            i=0;
        }
        return mutableImagen;
    }




    public void recuperarTurismo(Bundle bundle) {
        Turismo turismo=(Turismo) bundle.get("turismo");
        if (turismo != null) {
            turismoM.setValue(turismo);

        }
        if(turismo.getFotos()!=null)
        {  mutableImagen.setValue(turismoM.getValue().getFotos()[i]);}
    }
    public void getImg(int num){
        if(i+num==-1)
            i=turismoM.getValue().getFotos().length-1;
        else
            i=(i+num)%turismoM.getValue().getFotos().length;
        Log.d("valori",i+"");
        mutableImagen.setValue(turismoM.getValue().getFotos()[i]);
    }
}