package com.svalero.comunicacionentrefragments.beans;

import java.io.Serializable;

/**
 * Created by Alejandro S. on 25/02/15.
 */
public class Persona implements Serializable {

    private String nombre;
    private String apellidos;
    private String descripcion;

    public Persona(String nombre, String apellidos, String descripcion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
