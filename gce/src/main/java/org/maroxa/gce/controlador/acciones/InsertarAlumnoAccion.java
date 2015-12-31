package org.maroxa.gce.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.Alumno;

public class InsertarAlumnoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String primerApellido = request.getParameter("primerApellido");
        String segundoApellido = request.getParameter("segundoApellido");
        String curso = request.getParameter("curso");
        Alumno alumno = new Alumno(id, nombre, primerApellido, segundoApellido, curso);
        alumno.insertar();
        return "mostrarAlumnos.do";
    }

}
