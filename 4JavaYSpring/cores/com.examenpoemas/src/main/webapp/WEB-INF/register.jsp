<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrarse:</title>
<link rel="stylesheet" href="/css/styles.css"/>
</head>
<body>
	<h1>Poemas</h1>
	<ul id="nav">
		<li><a href="/">Login</a></li>
		<li><a href="/registro">Registro</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
	<h2>Registro</h2>
	<form:form action="/register" method="POST" modelAttribute="usuario">
		
		<form:label path="nombre">Nombre:</form:label>
		<form:input path="nombre" type="text" />
		<form:errors path="nombre" />
		
		<form:label path="apellido">Apellido:</form:label>
		<form:input path="apellido" type="text" />
		<form:errors path="apellido" />
		
		<form:label path="correo">Email:</form:label>
		<form:input path="correo" type="text" />
		<form:errors path="correo" />
		
		<form:label path="password">Contraseña:</form:label>
		<form:input path="password" type="password" />
		<form:errors path="password" />
		
		<form:label path="confirmarPassword">Confirmar Contraseña:</form:label>
		<form:input path="confirmarPassword" type="password" />
		<form:errors path="confirmarPassword" />
		
		<input class="button" type="submit" value="Registrase" />
	</form:form>
</body>
</html>