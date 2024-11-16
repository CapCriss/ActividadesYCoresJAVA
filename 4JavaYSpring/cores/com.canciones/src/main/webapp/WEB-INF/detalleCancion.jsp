<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Canción</title>
</head>
<body>
 <h1>${cancion.titulo}</h1>
 	<ul>
 		<li>Álbum: ${cancion.album }</li>
 		<li>Artista: ${cancion.artista.nombre} ${cancion.artista.apellido} </li>
 		<li>Género: ${cancion.genero}</li>
 		<li>Idioma: ${cancion.idioma}</li>
 		<li>Fecha de Creación: ${cancion.fecha_creacion }</li>
 		<li>Fecha de Actualización: ${cancion.fecha_actualizacion }</li>
 	</ul>
 	
 	<a href="/canciones/formulario/editar/${cancion.id}">Editar Cancion</a>
 	<a href="/canciones">Todas las Canciones</a>
 	
 	<form action="/canciones/eliminar/${cancion.id}" method="POST">
        <input type="hidden" name="_method" value="DELETE">
        <button>Eliminar</button>
    </form>
 	

</body>
</html>