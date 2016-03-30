package org.maroxa.gce;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.maroxa.gce.exception.GceException;

/**
 * Factoria del contexto de persistencia de JPA
 * @author Xavi
 *
 */
public final class JPAHelper {
    private static final Logger LOGGER = Logger.getLogger(JPAHelper.class);
    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    //Constructor privado de la clase
    private JPAHelper(){
    }
    
    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            //Crea el contexto de persistencia
            return Persistence.createEntityManagerFactory("gce");
        } catch (PersistenceException ex) {
            LOGGER.error(Constantes.ERROR_JPA);
            throw new GceException(ex.getMessage(),ex);
        }
    }

    /**
     * Devuelve el conexto de alicación de JPA
     * @return
     */
    public static EntityManagerFactory getJPAFactory() {
        return emf;
    }
}
