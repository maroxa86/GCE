<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.maroxa.gce.bo.Alumno"%>
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
		              <c:forEach var="curso" items="${listaDeCursos}">
                        <option value="${curso}">${curso}</option>
                      </c:forEach>
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