package com.example.microproyecto;

public class Formula {

    String categoria;
    String nombre;
    String informacion;

    public Formula(String categoria, String nombre, String informacion) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.informacion = informacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}
