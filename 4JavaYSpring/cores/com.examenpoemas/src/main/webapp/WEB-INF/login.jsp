<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iniciar Sesión:</title>
<link rel="stylesheet" href="/css/styles.css"/>
</head>
<body>
	<h1>Poemas</h1>
	<ul id="nav">
		<li><a href="/">Login</a></li>
		<li><a href="/registro">Registro</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
	<h2>Iniciar Sesión</h2>
	<form:form action="/login" method="POST" modelAttribute="loginUsuario">

		<form:label path="correo">Email:</form:label>
		<form:input path="correo" type="text" requiered="true"/>
		<form:errors path="correo" />
		
		<form:label path="password">Contraseña:</form:label>
		<form:input path="password" type="text" requiered="true"/>
		<form:errors path="password" />
		
		<input class="button" type="submit" value="Iniciar Sesión" />
	</form:form>
</body>
</html>