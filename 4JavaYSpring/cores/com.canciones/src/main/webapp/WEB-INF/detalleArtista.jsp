<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Artista </title>
</head>
<body>
<h1>Detalle de ${artista.nombre} ${artista.apellido}</h1>
	<ul>
 		<li>Nombre Completo: ${artista.nombre} ${artista.apellido}</li>
 		<li>Biografía: ${artista.biografia }</li>
 		<li>Fecha de Creación: ${artista.fechaCreacion }</li>
 		<li>Fecha de Actualización: ${artista.fechaActualizacion }</li>
 	</ul>
	<h2>Sus Canciones son:</h2>
	<ul>
		 <c:forEach var="cancion" items="${artista.canciones}">
       		 <li>${cancion.titulo}</li>
    	 </c:forEach>
	
	</ul>
	<a href="/artistas">Volver a Lista de Artistas</a>
	<a href="/canciones">Volver a Lista de Canciones</a>
</body>
</html>