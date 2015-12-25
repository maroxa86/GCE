<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.maroxa.gce.Alumno"%>
<%@ page import="org.maroxa.gce.exception.DataBaseException"%>
<%@ page import="java.sql.SQLException"%>
<%
    String id = request.getParameter("id");
    String nombre = request.getParameter("nombre");
    String primerApellido = request.getParameter("primerApellido");
    String segundoApellido = request.getParameter("segundoApellido");
    String curso = request.getParameter("curso");
    Alumno alumno = new Alumno(id, nombre, primerApellido, segundoApellido, curso);
    alumno.salvarAlumno();
    response.sendRedirect("mostrarAlumnos.jsp");
%>