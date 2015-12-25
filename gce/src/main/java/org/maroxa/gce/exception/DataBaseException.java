package org.maroxa.gce.exception;

public class DataBaseException extends RuntimeException {
    private static final long serialVersionUID = 5362661755014480219L;

    public DataBaseException() {
        super();
    }

    public DataBaseException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public DataBaseException(String arg0) {
        super(arg0);
    }

    public DataBaseException(Throwable arg0) {
        super(arg0);
    }
}
