<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--  sentencias de import necesarias para jdbc-->
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%
	//1 
	String id = request.getParameter("id");
	String nombre = request.getParameter("nombre");
	String primerApellido = request.getParameter("primerApellido");
	String segundoApellido = request.getParameter("segundoApellido");
	String curso = request.getParameter("curso");
	Connection conexion = null;
	Statement sentencia = null;
	int filas = 0;
	try {
		//2 Creación de la conexión con la base de datos
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/gce", "root", "root");
		sentencia = conexion.createStatement();
		//3 Creación de la sentencia SQL para insertar los datos
		String consultaSQL = "insert into Alumnos (id, nombre, primerApellido, segundoApellido, curso) values ";
		consultaSQL += "('" + id + "','" + nombre + "','" + primerApellido + "', '" + segundoApellido +"', " + curso +")";
		//4 Ejecución de la sentencia
		filas = sentencia.executeUpdate(consultaSQL);
		response.sendRedirect("mostrarAlumnos.jsp");
	} catch (ClassNotFoundException e) {
		System.out.println("Error en la carga del driver" + e.getMessage());
	} catch (SQLException e) {
		System.out.println("Error accediendo a la base de datos" + e.getMessage());
	} finally {
		//5 Cerramos la conexión
		if (sentencia != null) {
			try {
				sentencia.close();
			} catch (SQLException e) {
				System.out.println("Error cerrando la sentencia" + e.getMessage());
			}
		}
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {
				System.out.println("Error cerrando la conexion" + e.getMessage());
			}
		}
	}
%>