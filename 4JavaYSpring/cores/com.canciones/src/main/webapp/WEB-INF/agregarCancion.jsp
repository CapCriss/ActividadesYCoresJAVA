<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Cancion</title>
</head>
<body>
<h1>Ingresa los datos de la canción:</h1>
	<form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
		<form:label path="titulo">Titulo de la Canción:</form:label>
		<form:input path="titulo" type="text"/>
		<form:errors path="titulo"/>
		
		<form:label path="artista">Artista:</form:label>
		<form:select path="artista">
		<c:forEach var="artista" items="${artistas}">
			<option value="${artista.id}">${artista.nombre} ${artista.apellido}</option>
		</c:forEach>
		</form:select>
		
		<form:errors path="artista"/>
		
		<form:label path="album">Álbum:</form:label>
		<form:input path="album" type="text"/>
		<form:errors path="album"/>
		
		<form:label path="genero">Género:</form:label>
		<form:input path="genero" type="text"/>
		<form:errors path="genero"/>
		
		<form:label path="idioma">Idioma:</form:label>
		<form:input path="idioma" type="text"/>
		<form:errors path="idioma"/>
		
		<input type="submit" value="Agregar Canción">
	
	</form:form>
	<a href="/canciones">Volver a Lista de Canciones</a>
</body>
</html>