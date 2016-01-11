package org.maroxa.gce.exception;

public class GceException extends RuntimeException {
    private static final long serialVersionUID = 5362661755014480219L;

    public GceException() {
        super();
    }

    public GceException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public GceException(String arg0) {
        super(arg0);
    }

    public GceException(Throwable arg0) {
        super(arg0);
    }
}
