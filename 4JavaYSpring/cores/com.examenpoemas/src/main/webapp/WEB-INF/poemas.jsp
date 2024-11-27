<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Poemas:</title>
<link rel="stylesheet" href="/css/styles.css"/>
</head>
<body>
<h1>Poemas</h1>
	<ul id="nav">
		<li><a href="/poemas">Todos los poemas</a></li>
		<li><a href="/form/agregar">Agregar Poema</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
	<h2>Bienvenido de vuelta ${nombreCompleto}</h2>
	<ul class="lista-poemas">
    <c:forEach var="poema" items="${poemas}">
        <li class="poema">
            <a href="/detalle/${poema.id}" class="titulo">${poema.titulo}</a>
            <div class="informacion">
                <span class="etiqueta-autor">Autor:</span>
                <span class="autor">${poema.autor}</span>
            </div>
            <a class="button-editar" href="/form/editar/${poema.id}">&#9998;</a>
        </li>
    </c:forEach>
</ul>

</body>
</html>