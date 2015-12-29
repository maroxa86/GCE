<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.maroxa.gce.Alumno"%>
<%@ page import="java.util.List" %>
<%@ page import="org.maroxa.gce.exception.DataBaseException" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gestión Centro Escolar</title>
	</head>
	<body>
		<form id="altaAlumno" method="POST" action="insertarAlumno.do">
			<fieldset>
				<legend>Alta Nuevo Usuario</legend>
				<p>
					<label id="id">Identificador:</label>
					<input type="text" id="id" name="id">
				</p>
				<p>
					<label id="nombre">Nombre:</label>
					<input type="text" id="nombre" name="nombre">
				</p>
				<p>
					<label id="primerApellido">Primer Apellido:</label>
					<input type="text" id="primerApellido" name="primerApellido">
				</p>
				<p>
					<label id="segundoApellido">Segundo Apellido:</label>
					<input type="text" id="segundoApellido" name="segundoApellido">
				</p>
				<p>
					<label id="curso">Curso:</label>
					<select name="curso">
		           <option value="seleccionar" selected="selected">Seleccionar</option>
		           <%
		               List<String> listaCursos = Alumno.buscarTodosLosCursos();
		               for(String curso : listaCursos){%>
		                   <option value="<%=curso %>"><%=curso %></option>
	               <%  }%>
			       </select>
			       <br/>
				</p>
				<p>
					<input type="submit" value="Alta" id="alta"/>
				</p>
			</fieldset>
		</form>
	</body>
</html>