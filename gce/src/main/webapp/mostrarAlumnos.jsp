<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		       <c:forEach var="curso" items="${listaDeCursos}">
		               <option value="${curso}">${curso}</option>
		       </c:forEach>
		   </select>
		   <input type="submit" value="Filtrar" id ="filtar" name="filtrar">
	   </form>
	   <br/>
	   <c:forEach var="alumno" items="${listaDeAlumnos}">
	       ${alumno.id} ${alumno.nombre} ${alumno.primerApellido} ${alumno.segundoApellido} ${alumno.curso}
		  <a href="editarAlumno.do?id=${alumno.id}">Editar</a>
          <a href="borrarAlumno.do?id=${alumno.id}">Borrar</a>
		  <br />
	   </c:forEach>
	   <a href="altaAlumno.do">Nuevo Alumno</a>
	</body>
</html>