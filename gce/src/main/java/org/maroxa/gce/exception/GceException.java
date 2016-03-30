package org.maroxa.gce.exception;

/**
 * Exception creada para la gestión de errores de la aplicación.
 * Extiende la clase RuntimeException
 * @author Xavi
 *
 */
public class GceException extends RuntimeException {
    private static final long serialVersionUID = 5362661755014480219L;

    /**
     * Constructor generico
     */
    public GceException() {
        super();
    }

    /**
     * Constructor al que se le proporciona el mensaje de error y un objeto Throwable
     * @param arg0 Mensaje de error
     * @param arg1 Objeto Throwable
     */
    public GceException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * Constructor al cual se le proporciona un mensaje de error
     * @param arg0 Mensaje de error
     */
    public GceException(String arg0) {
        super(arg0);
    }

    /**
     * Constructor al cual se le proporciona un objeto Throwable
     * @param arg0 Objeto Throwable
     */
    public GceException(Throwable arg0) {
        super(arg0);
    }
}
