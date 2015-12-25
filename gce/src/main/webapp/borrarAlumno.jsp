<%@page import="org.maroxa.gce.exception.DataBaseException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.maroxa.gce.Alumno"%>
<%@ page import="org.maroxa.gce.exception.DataBaseException"%>
<%
    String id = request.getParameter("id");
    Alumno alumno = new Alumno(id);
    alumno.borrar();
    response.sendRedirect("mostrarAlumnos.jsp");
%>