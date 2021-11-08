package edu.upc.dsa.models;

public class Vacuna {
    public String id;
    public String marca;
    public int vacunasAplicadas = 0;

    public Vacuna(String marca) {
        this.id = marca;
        this.marca = marca;
    }

    public Vacuna(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void addContadorVacunas(){
        this.vacunasAplicadas = vacunasAplicadas+1;
    }

    public int getVacunasAplicadas() {
        return vacunasAplicadas;
    }

    public void setVacunasAplicadas(int vacunasAplicadas) {
        this.vacunasAplicadas = vacunasAplicadas;
    }
}
