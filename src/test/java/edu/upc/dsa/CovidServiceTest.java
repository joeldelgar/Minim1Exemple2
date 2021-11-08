package edu.upc.dsa;

import edu.upc.dsa.models.Persona;
import edu.upc.dsa.models.Vacuna;
import org.apache.log4j.Logger;
import org.joda.time.LocalDateTime;

public class CovidServiceTest {

    private static Logger logger = Logger.getLogger(CovidServiceTest.class);
    Covid19Manager manager = CovidManagerImpl.getInstance();
    public void SetUp(){
        Vacuna v1 = new Vacuna("Astrazeneca");
        Vacuna v2 = new Vacuna("Moderna");
        Vacuna v3 = new Vacuna("Pfizer");

        manager.addVacunaLista(v1);
        manager.addVacunaLista(v2);
        manager.addVacunaLista(v3);

        manager.addPersonaLista("Joel", null, null);
        manager.addPersonaLista("Esther", null, null);
        manager.addPersonaLista("Maria", null, null);


        manager.addVacuna("Joel","Moderna",LocalDateTime.now().toString());
        manager.addVacuna("Maria", "Pfizer", LocalDateTime.now().toString());
    }

    public void TearDown(){
        manager.clear();
    }

    public void testVacuna(){
        Persona p = manager.getUserById("Esther");
        manager.addVacuna("Esther", "Moderna", LocalDateTime.now().toString());
    }

    public void testSeguimiento(){
        Persona p = manager.getUserById("Esther");
        manager.addSeguimiento("Esther",LocalDateTime.now().toString(), "Me estoy estrasando");
        manager.addSeguimiento("Esther", LocalDateTime.now().toString(), "Me encuentro mejor");
    }
}
