<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListaProveedor</title>
</head>
<body>

	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>***Listado de proveedores***</h1>
	<h3>menu:</h3>
	<h3>
		<a href="redirect:/">Vista principal</a>
	</h3>
	<h3>
		<a href="listaC">Consultar las Categorias</a>
	</h3>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Telefono</th>
			<th>Direccion</th>
			<th>Acciones</th>
		</tr>
		<c:forEach var="ver" items="${listaProv}">
			<tr>
				<td>${ver.idProveedor}</td>
				<td>${ver.nombreProve}</td>
				<td>${ver.telefono}</td>
				<td>${ver.direccion}</td>
				
			</tr>
		</c:forEach>
	</table>
	<br />
</body>
</html>