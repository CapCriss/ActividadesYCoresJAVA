<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Libro</title>
</head>
<body>
	
	
	<c:if test="${existe == false}">
		<p>El Libro no se encuentra en nuestra lista. </p>
	
	</c:if>
	
	<c:if test="${existe == true}">
	<h1>Libro: ${nombre}</h1>
		<ul>
				<li>Nombre: ${nombre}</li>
				<li>Autor: ${autor}</li>
			
		</ul>
	
	</c:if>
		
	
	
	
</body>
</html>