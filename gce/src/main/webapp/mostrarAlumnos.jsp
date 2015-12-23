<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Gestión Centro Escolar</title>
	</head>
	<body>
		<%
			Connection conexion = null;
			Statement sentencia = null;
			ResultSet rs = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//1 Creación de la conexión
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/gce", "root", "root");
				sentencia = conexion.createStatement();
				//2 Creación de la consulta para recuperar los datos
				String consultaSQL = "select id, nombre, primerapellido, segundoapellido, curso from Alumnos";
				//3 y 4 Ejecución de la sentencia
				rs = sentencia.executeQuery(consultaSQL);
				//5 Mostramos los datos recuperados
				while (rs.next()) {
		%>
		<%=rs.getString("id")%>
		<%=rs.getString("nombre")%>
		<%=rs.getString("primerapellido")%>
		<%=rs.getString("segundoapellido")%>
		<%=rs.getString("curso")%>
		<br />
		<%
			}
			} catch (ClassNotFoundException e) {
				System.out.println("Error en la carga del driver" + e.getMessage());
			} catch (SQLException e) {
				System.out.println("Error accediendo a la base de datos" + e.getMessage());
			} finally {
				//6  cerramos la conexión-
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						System.out.println("Error cerrando el resultset" + e.getMessage());
					}
				}
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
		<a href="altaAlumno.jsp">Nuevo Alumno</a>
	</body>
</html>