<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Canciones</title>
</head>
<body>
	<h1>Todas las Canciones:</h1>
	<ul>
		<c:forEach var="cancion" items="${canciones}">
			<li>Título: ${cancion.titulo}</li>
			<li>Álbum: ${cancion.album}</li>
			<li>Artista: ${cancion.artista.nombre} ${cancion.artista.apellido}</li>
			
			<a href="/canciones/detalle/${cancion.id}">Mostrar detalles</a>
	
	</c:forEach>
	</ul>
	
	<a href="/canciones/formulario/agregar">Agregar Canción</a>
	<a href="/artistas">Ir a Artistas</a>
</body>
</html>