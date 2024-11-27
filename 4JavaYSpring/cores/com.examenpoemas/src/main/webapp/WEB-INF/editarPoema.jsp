<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Poema</title>
<link rel="stylesheet" href="/css/styles.css"/>
</head>
<body>
	<ul id="nav">
		<li><a href="/poemas">Todos los poemas</a></li>
		<li><a href="/form/agregar">Agregar Poema</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
	<h2>Editar Poema</h2>
	<form:form action="/actualizar/${poema.id}" method="POST" modelAttribute="poema">
		<input type="hidden" name="_method" value="PUT" />
	
		<form:label path="titulo">Título:</form:label>
		<form:input path="titulo" type="text" />
		<form:errors path="titulo"/>
		
		<form:label path="autor">Autor:</form:label>
		<form:input path="autor" type="text" />
		<form:errors path="autor"/>
		
		<form:label path="anio">Año:</form:label>
		<form:input path="anio" type="text" />
		<form:errors path="anio"/>
		
		<form:label path="letra">Letra:</form:label>
		<form:textarea path="letra" type="text" />
		<form:errors path="letra"/>
		

		<input class="button" type="submit" value="editar">
	</form:form>

</body>
</html>