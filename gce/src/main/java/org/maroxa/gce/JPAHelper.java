package org.maroxa.gce;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.exception.GceException;

public class JPAHelper {
    private static final Logger LOGGER = Logger.getLogger(Alumno.class);
    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private JPAHelper(){
    }
    
    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            return Persistence.createEntityManagerFactory("gce");
        } catch (PersistenceException ex) {
            LOGGER.error(Constantes.ERROR_JPA);
            throw new GceException(ex.getMessage(),ex);
        }
        catch(Exception e){
            LOGGER.error(Constantes.ERROR_JPA);
            throw new GceException(e.getMessage(),e);
        }
    }

    public static EntityManagerFactory getJPAFactory() {
        return emf;
    }
}
