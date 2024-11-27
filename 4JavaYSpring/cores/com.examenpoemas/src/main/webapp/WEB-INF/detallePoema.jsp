<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle</title>
<link rel="stylesheet" href="/css/styles.css"/>
</head>
<body>
	<ul id="nav">
		<li><a href="/poemas">Todos los poemas</a></li>
		<li><a href="/form/agregar">Agregar Poema</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
	<h2>Detalle de Poema</h2>
	<h3>${poema.titulo}</h3>
	<ul>
		<li><b>Agregado Por:</b> ${nombreCompleto}</li>
		<li><b>Autor:</b> ${poema.autor}</li>
		<li><b>Año:</b> ${poema.anio}</li>
		<li><b>Letra:</b> ${poema.letra}</li>
	</ul>
	<c:if test="${poema.creador.id == idUsuario}">
        <form action="/eliminar/${poema.id}" method="POST">
        <input type="hidden" name="_method" value="DELETE"/>
        <button  class="button" type="submit">Eliminar Poema</button>
        </form>
    </c:if>

</body>
</html>