package org.maroxa.gce;

/**
 * Clase que contiene las constantes genericas a la aplicación.
 * @author Xavi
 *
 */
public final class Constantes {
 
    //Constantes LOGS
    public static final String INICIO_LOG = "Inicio -";
    public static final String FIN_LOG = "Fin -";
    
    //ERRORES APLICACION
    public static final String CONSULTA_SQL = "ConsultaSQL";
    public static final String ERROR_INSERTAR_ALUMNO = "ERROR AL INSERTAR UN NUEVO ALUMNO";
    public static final String ERROR_BORRAR_ALUMNO = "ERROR AL BORRAR UN ALUMNO";
    public static final String ERROR_MODIFICAR_ALUMNO = "ERROR AL MODIFICAR LOS DATOS DE UN ALUMNO";
    public static final String ERROR_JPA = "Error al crear la factoria de JPA";
    
    private Constantes(){    
    }
}
