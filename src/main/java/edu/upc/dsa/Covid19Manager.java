package edu.upc.dsa;

import edu.upc.dsa.models.Persona;
import edu.upc.dsa.models.Seguimiento;
import edu.upc.dsa.models.Vacuna;
import java.util.List;

public interface Covid19Manager {

    public void addVacuna (String idUser, String idVacuna, String data);
    //Aplicar una vacuna sobre una persona.
    public List<Vacuna> listarVacunas();
    //Listar las vacunaciones ordenadas por vacunas y dentro de las vacunas por orden de vacunación.
    public List<Vacuna> listarVacunasMarca();
    //Listado de marcas de vacunas ordenado descendentemente por el número de vacunas aplicadas.
    public Seguimiento addSeguimiento(String idUser, String data, String descripcion);
    //Añadir un seguimiento sobre un usuario que se haya vacunado
    public List<Seguimiento> listarSeguimientos(String idUser);
    //Listado de seguimientos realizados a una persona.

    public void addVacunaLista(Vacuna v);
    public void addPersonaLista(String nom, String vacuna, List<Seguimiento> list);
    public void clear();
    public Persona getUserById(String name);
    public Vacuna getVacunaById(String marca);
}
