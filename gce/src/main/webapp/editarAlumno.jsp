<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.maroxa.gce.Alumno"%>
<%@page import="org.maroxa.gce.exception.DataBaseException"%>
<%@ page import="java.util.List" %>
<%Alumno alumno = Alumno.buscarAlumnoPorClave(request.getParameter("id")); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gestión Centro Escolar</title>
	</head>
	<body>
		<form id="altaAlumno" method="POST" action="salvarAlumno.jsp">
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
                        <option value="seleccionar">Seleccionar</option>
			           <%
			           
			               List<String> listaCursos = Alumno.buscarTodosLosCursos();
			               for(String curso : listaCursos){
			                 if(curso.equals(alumno.getCurso())){%>
			                   <option value="<%=curso %>" selected="selected"><%=curso %></option>
			               <%}
			                 else{%>
			                   <option value="<%=curso %>"><%=curso %></option>  
			                 <%}
			               }%>
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