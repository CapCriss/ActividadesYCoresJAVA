<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Receta</title>
<link rel= "stylesheet" href="/css/styles.css">
</head>
<body>
	<h1>${nombre}</h1>

	<c:if test= "${ingredientes.equals(nombre) == null}">
			<p>La receta no se encuentra en nuestra lista.</p>
	</c:if>
		<ul>
			<c:forEach var="ingrediente" items="${ingredientes}">
			 		<li>${ingrediente}</li>
			 </c:forEach>
		 </ul>
		 


</body>
</html>