package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String vacunas = null;

    public List<Seguimiento> listaSeguimiento = new ArrayList<>();

    public Persona(String nombre, String vacunas, List<Seguimiento> listaSeguimiento) {
        this.nombre = nombre;
        this.vacunas = vacunas;
        this.listaSeguimiento = listaSeguimiento;
    }

    public Persona(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }

    public List<Seguimiento> getListaSeguimiento() {
        return listaSeguimiento;
    }

    public void setListaSeguimiento(List<Seguimiento> listaSeguimiento) {
        this.listaSeguimiento = listaSeguimiento;
    }


}
