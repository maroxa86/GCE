<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gestión Centro Escolar</title>
	</head>
	<body>
		<form id="altaAlumno" method="POST" action="insertarAlumno.jsp">
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
					<input type="text" id="curso" name="curso">
				</p>
				<p>
					<input type="submit" value="Alta" id="alta"/>
				</p>
			</fieldset>
		</form>
	</body>
</html>