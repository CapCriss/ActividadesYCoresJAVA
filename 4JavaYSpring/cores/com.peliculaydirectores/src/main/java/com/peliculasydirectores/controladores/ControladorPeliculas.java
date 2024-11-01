package com.peliculasydirectores.controladores;


import java.util.HashMap;
// import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class ControladorPeliculas {
	private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();
	
	// CONSTRUCTOR
	public ControladorPeliculas() {
		listaPeliculas.put("Winnie the Pooh", "Don_Hall");	
		listaPeliculas.put("El zorro y el sabueso", "Ted_Berman");
		listaPeliculas.put("Tarzán", "Kevin_Lima");		
		listaPeliculas.put("Mulán", "Barry_Cook");
		listaPeliculas.put("Oliver", "KevinLima");	
		listaPeliculas.put("Big Hero 6", "Don Hall");
	}
	
	// ********** METODOS / FUNCIONES ****************
	@GetMapping("/saludo") // ****PRUEBA DE LEVANTAR EL SERVIDOR****
	public String inicio() {
		return "hola string boot!";
	}
	
	// obtenerTodasLasPeliculas(): Método que responde a la ruta /peliculas y retorna un string con la lista de todas las películas disponibles
	@GetMapping("/peliculas")
	public String obtenerTodasLasPeliculas() {
		String todasLasPeliculas = "";
		for (Map.Entry<String, String> peliculas : listaPeliculas.entrySet()) {
			
			 todasLasPeliculas += "PELÍCULA: " + peliculas.getKey() + "DIRECTOR: " + peliculas.getValue() + "\n";
		}
		return todasLasPeliculas;
	}
	

	
	// obtenerPeliculaPorNombre(): Método que responde a la ruta /peliculas/{nombre} y retorna la información de una película específica, devuelve el nombre de la película y su director. En caso de que la película no exista en la lista devolver un mensaje como el siguiente:  «La película no se encuentra en nuestra lista.»
	@GetMapping("/peliculas/{nombre}")
	public String obtenerPeliculaPorNombre(@PathVariable(value = "nombre") String nombre) {
		String peli = buscarPelicula(nombre).toString();
		return peli;
	}
	// FUNCION PARA BUSCAR LA PELICULA
	private String buscarPelicula(String nombre) {
		System.out.println(nombre);
		if (listaPeliculas.containsKey(nombre)) {
			String director = listaPeliculas.get(nombre);
			return "PELICULA: " + nombre + " ,DIRECTOR: " + director;
			
		}else {
			return "La película no se encuentra en nuestra lista";
		}
	}
	
	
	
	// obtenerPeliculasPorDirector(): Método que responde a la ruta /peliculas/director/{nombre} y retorna un string con la lista de todas las películas que tienen ese director asignado. En caso de que el director no exista en la lista devolver un mensaje como el siguiente: «No contamos con películas con ese director en nuestra lista.»
	
	@GetMapping("/peliculas/director/{nombre}")
	public String obtenerPeliculasPorDirector(@PathVariable(value = "nombre") String nombre) {
		String peli = buscarDirector(nombre).toString();
		return peli;
	}
	// FUNCION PARA BUSCAR LA PELICULA POR DIRECTOR Barry_Cook DEVUELVE MULÁN (CORRECTO)
	private String buscarDirector(String nombre) {
		for (Map.Entry<String, String> director : listaPeliculas.entrySet()) {
            if (director.getValue().equals(nombre)) {
                return director.getKey();
            }
		}
		return "No contamos con películas con ese director en nuestra lista.";
	}	
	
}
