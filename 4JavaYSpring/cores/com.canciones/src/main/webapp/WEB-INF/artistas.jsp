<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artistas</title>
</head>
<body>
<h1>Todos los Artistas:</h1>
		<ul>
			<c:forEach var="artistas" items="${artistas}">
				<a href="/artistas/detalle/${artistas.id}"> <li>${artistas.nombre} ${artistas.apellido}</li></a>
				
			</c:forEach>
		</ul>
		<a href="/canciones">Ir a Canciones</a>

</body>
</html>