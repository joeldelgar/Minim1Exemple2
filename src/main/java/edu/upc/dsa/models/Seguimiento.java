package edu.upc.dsa.models;

public class Seguimiento {
    public String data;
    public String descripcion;

    public Seguimiento(String data, String descripcion) {
        this.data = data;
        this.descripcion = descripcion;
    }
    public Seguimiento(){}

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
