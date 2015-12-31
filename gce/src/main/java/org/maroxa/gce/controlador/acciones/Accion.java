package org.maroxa.gce.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.maroxa.gce.exception.DataBaseException;

public abstract class Accion {
    private static final Logger LOGGER = Logger.getLogger(Accion.class);
    
    public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);
    
    public static Accion getAccion(String tipo){
        Accion accion = null;
        try {
            accion = (Accion)Class.forName(ClassUtils.getPackageName(Accion.class) + "." + 
                                            StringUtils.capitalize(tipo) + "Accion").newInstance();
        } catch (InstantiationException e) {
            LOGGER.error("Error Instanciación.");
            LOGGER.error(e.getMessage());
            throw new DataBaseException(e.getMessage(),e);
        } catch (IllegalAccessException e) {
            LOGGER.error("Error de acceso ilegal.");
            LOGGER.error(e.getMessage());
            throw new DataBaseException(e.getMessage(),e);
        } catch (ClassNotFoundException e) {
            LOGGER.error("No se encuentra la clase.");
            LOGGER.error(e.getMessage());
            throw new DataBaseException(e.getMessage(),e);
        }
        
        return accion;
    }
}
