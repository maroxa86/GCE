package org.maroxa.gce.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.maroxa.gce.bo.Alumno;
import org.maroxa.gce.bo.Curso;
import org.maroxa.gce.dao.AlumnoDAO;
import org.maroxa.gce.factory.DAOAbstractFactory;
import org.maroxa.gce.factory.DAOFactory;

public class InsertarAlumnoAccion extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        DAOFactory factory = DAOAbstractFactory.getInstance();
        AlumnoDAO alumnoDAO = factory.getAlumnoDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String primerApellido = request.getParameter("primerApellido");
        String segundoApellido = request.getParameter("segundoApellido");
        String curso = request.getParameter("curso");
        Alumno alumno = new Alumno(id, nombre, primerApellido, segundoApellido, new Curso(Integer.parseInt(curso)));
        alumnoDAO.insertar(alumno);
        return "mostrarAlumnos.do";
    }
}
