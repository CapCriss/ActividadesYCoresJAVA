<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libros</title>
</head>
<body>

	<h1>Libros:</h1>
	
	
		<ul>
			<c:forEach var="libro" items="${libros}">
			
				<li> <a href="/libros/${libro.key}">${libro.key}</a></li>
				
			</c:forEach>
		</ul> 
	


</body>
</html>