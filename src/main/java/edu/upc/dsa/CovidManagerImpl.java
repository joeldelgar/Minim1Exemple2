package edu.upc.dsa;

import edu.upc.dsa.models.Persona;
import edu.upc.dsa.models.Seguimiento;
import edu.upc.dsa.models.Vacuna;
import org.apache.log4j.Logger;

import java.util.*;

public class CovidManagerImpl implements Covid19Manager{

    //Estructura de Dades
    HashMap<String,Persona> listaPersonas = new HashMap<String,Persona>();
    List<Vacuna> listaVacunados = new LinkedList<>();
    ArrayList<Vacuna> listaVacunas = new ArrayList<>();
    List<Seguimiento> listaSeguimiento = new ArrayList<>();

    static Logger logger = Logger.getLogger(CovidManagerImpl.class);

    //Singleton
    private static CovidManagerImpl manager;
    public static CovidManagerImpl getInstance(){
        if(manager == null){
            manager = new CovidManagerImpl();
        }
        return  manager;
    }

    //Constructor
    public CovidManagerImpl(){}

    //Funcions
    @Override
    public void addVacuna(String idUser, String idVacuna, String data) {
        Persona persona = this.listaPersonas.get(idUser);
        Vacuna vacuna = getVacunaByName(idVacuna);
        if(persona != null){
            logger.info("Persona trobada:"+idUser);
            persona.setVacunas(idVacuna); //La persona x ha sigut vacunada amb la vacuna Y
            vacuna.addContadorVacunas(); //Incremento el valor de vegades que aquesta vacuna s'ha administrat
            listaVacunados.add(vacuna); //Afegim a la llista de vacunats
        }
    }

    public Vacuna getVacunaByName(String marcaVacuna) {
        Vacuna vacuna = null;
        for (Vacuna v: this.listaVacunas){
            if (v.getMarca().compareTo(marcaVacuna)==0) {
                vacuna= v;
            }
        }
        return vacuna;
    }


    @Override
    public List<Vacuna> listarVacunas() {
        List<Vacuna> r = new ArrayList<>();
        Collections.sort(r, new Comparator<Vacuna>() {
            @Override
            public int compare(Vacuna o1, Vacuna o2) {
                return 0;
            }
        });
        logger.info("Llista Ordenada de Vacunes: "+r.toString());
        return r;
    }

    @Override
    public List<Vacuna> listarVacunasMarca() {
        return null;
    }

    @Override
    public void addSeguimiento(String idUser, String data, String descripcion){
        Persona p = this.listaPersonas.get(idUser);
        Seguimiento s = new Seguimiento(data,descripcion);
        p.listaSeguimiento.add(s);
        logger.info("A la persona"+idUser+" se li ha afegit un seguiment:"+s);
    }

    @Override
    public List<Seguimiento> listarSeguimientos(String idUser) {
        Persona p = this.listaPersonas.get(idUser);
        List<Seguimiento> list = p.getListaSeguimiento();
        logger.info("S'ha trobat la llista de: "+idUser+"\n"+list.toString());
        return list;
    }

    @Override
    public void addVacunaLista(Vacuna v) {
        listaVacunas.add(v);
    }

    @Override
    public void addPersonaLista(String nom, String vacuna, List<Seguimiento> list) {
        Persona p = new Persona(nom,vacuna,list);
        listaPersonas.put(nom,p);
    }

    @Override
    public void clear() {
        listaPersonas.clear();
        listaVacunas.clear();
        listaVacunados.clear();
        listaSeguimiento.clear();
    }

    @Override
    public Persona getUserById(String name) {
        Persona p = listaPersonas.get(name);
        return p;
    }


}
