<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.maroxa.gce.Alumno"%>
<%@page import="org.maroxa.gce.exception.DataBaseException"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Gestión Centro Escolar</title>
	</head>
	<body>
	   <form id="filtarCurso" name="filtarCurso" method="get" action="filtrarAlumnos.do">
		   <select name="curso">
		       <option value="seleccionar" selected="selected">Seleccionar</option>
		       <%
		           List<String> listaCursos = (List<String>) request.getAttribute("listaDeCursos");
		           for(String curso : listaCursos){%>
		               <option value="<%=curso %>"><%=curso %></option>
	               <%}%>
		   </select>
		   <input type="submit" value="Filtrar" id ="filtar" name="filtrar">
	   </form>
	   <br/>
		<%
			  List<Alumno> listaAlumnos = null;
			  listaAlumnos = (List<Alumno>) request.getAttribute("listaDeAlumnos");
			  for(Alumno alumno : listaAlumnos) {
			%>
			<%=alumno.getId()%>
			<%=alumno.getNombre()%>
			<%=alumno.getPrimerApellido()%>
			<%=alumno.getSegundoApellido()%>
			<%=alumno.getCurso()%>
			<a href="editarAlumno.do?id=<%=alumno.getId() %>">Editar</a>
			<a href="borrarAlumno.do?id=<%=alumno.getId() %>">Borrar</a>
			<br />
			<%}%>
		<a href="altaAlumno.jsp">Nuevo Alumno</a>
	</body>
</html>