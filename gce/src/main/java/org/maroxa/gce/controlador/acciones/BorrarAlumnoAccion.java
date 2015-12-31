package org.maroxa.gce.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.Alumno;

public class BorrarAlumnoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Alumno alumno = new Alumno(id);
        alumno.borrar();
        return "mostrarAlumnos.do";
    }
}
