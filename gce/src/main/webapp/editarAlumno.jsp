<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.maroxa.gce.bo.Alumno"%>
<%Alumno alumno = Alumno.buscarAlumnoPorClave(request.getParameter("id")); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gestión Centro Escolar</title>
	</head>
	<body>
		<form id="altaAlumno" method="POST" action="salvarAlumno.do">
			<fieldset>
				<legend>Alta Nuevo Usuario</legend>
				<p>
					<label id="id">Identificador:</label>
					<input type="text" id="id" name="id" value="<%=alumno.getId()%>"/>
				</p>
				<p>
					<label id="nombre">Nombre:</label>
					<input type="text" id="nombre" name="nombre" value="<%=alumno.getNombre()%>"/>
				</p>
				<p>
					<label id="primerApellido">Primer Apellido:</label>
					<input type="text" id="primerApellido" name="primerApellido" value="<%=alumno.getPrimerApellido()%>"/>
				</p>
				<p>
					<label id="segundoApellido">Segundo Apellido:</label>
					<input type="text" id="segundoApellido" name="segundoApellido" value="<%=alumno.getSegundoApellido()%>"/>
				</p>
				<p>
					<label id="curso">Curso:</label>
					<select name="curso">
                      <option value="seleccionar" selected="selected">Seleccionar</option>
                      <c:forEach var="curso" items="${listaDeCursos}">
                        <c:choose>
                            <c:when test="${curso.id} == <%=alumno.getCurso()%>">
		                        <option value="${curso.id}" selected="selected">${curso.nombre}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${curso.id}">${curso.nombre}</option>
                            </c:otherwise>
                        </c:choose>
                      </c:forEach>
                    </select>
			       <br/>
				</p>
				<p>
					<input type="submit" value="Guardar" id="guardar"/>
				</p>
			</fieldset>
        </form>
    </body>
</html>