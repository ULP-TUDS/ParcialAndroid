package com.miapp.parcial.modelo;

import java.io.Serializable;

public class Turismo implements Serializable {
    private String nombre;
    private String descripcion;
    private int[] fotos;
    private String horario;

    public Turismo() {

    }

    public Turismo(String nombre, String descripcion, int[] fotos, String horario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotos = fotos;
        this.horario = horario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int[] getFotos() {
        return fotos;
    }

    public void setFotos(int[] fotos) {
        this.fotos = fotos;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
