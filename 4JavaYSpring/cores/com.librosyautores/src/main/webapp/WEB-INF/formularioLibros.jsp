<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Libros</title>
</head>
<body>
	<h1>Libro que desea agregar:</h1>
	<form action="/procesa/libro" method="POST">
		<label for="nombreLibro">Nombre del Libro:</label>
		<input type="text" name="nombreLibro">
		<label for="autorLibro">Nombre del Autor:</label>
		<input type="text" name="autorLibro">
		<button type="submit">Agregar a la Lista</button>
	
	</form>

</body>
</html>