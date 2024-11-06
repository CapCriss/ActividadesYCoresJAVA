package com.exploradorderecetas.controladores;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class ControladorRecetas {

	// ATRIBUTOS
	
	private static String[] listaRecetas = {"Pizza", "Espagueti", "Lasaña"};
	private static HashMap<String, String []> recetasConIngredientes = new HashMap<String, String[]>();
	
	//CONSTRUCTOR / LLENADO DE VALORES
	
	public ControladorRecetas() {
		String [] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
		recetasConIngredientes.put("Pizza", pizza);
		String [] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
		recetasConIngredientes.put("Espagueti", espagueti);
		String [] lasaña = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
		recetasConIngredientes.put("Lasaña", lasaña);
	}
	
	
	// METODOS / FUNCIONES
	//probar servidor
		@GetMapping("/saludo")
		public String inicio() {
			return "hola spring boot! recetas";
		}
	
	// obtenerTodasLasRecetas(): Método que responde a la ruta /recetas. Este método toma la lista de recetas y la agrega como atributo “listaRecetas” a un objeto Modelo para enviar hacia el JSP llamado recetas.jsp
	
	@GetMapping("/recetas")
	public String obtenerTodasLasRecetas(Model modelo) {
		modelo.addAttribute("listaRecetas", Arrays.asList(listaRecetas)); // CONVIERTE EL ARRAY EN UNA LISTA PARA AÑADIRLO AL MODELO
	
		return "recetas.jsp"; // "recetas" ?
	}
	
	// obtenerRecetaPorNombre(): Método que responde a la ruta /recetas/{nombre}. Este método busca el nombre de la receta y agrega su nombre y sus ingredientes en dos atributos respectivamente a un objeto Modelo para enviar hacía el JSP llamado detalleReceta.jsp En caso de que la receta no exista en la lista devolver un mensaje como el siguiente: La receta no se encuentra en nuestra lista.
	
	@GetMapping("/recetas/{nombre}")
	public String obtenerRecetaPorNombre(Model modelo, @PathVariable(value = "nombre") String nombre) {
		modelo.addAttribute("nombre",nombre);
		String []ingredientes=buscarReceta(nombre);
		// ingredientes.equals(nombre);
		modelo.addAttribute("ingredientes",ingredientes);
		return "detalleReceta.jsp";
	}
	
	// FUNCION PARA BUSCAR RECETA
	 private String[] buscarReceta( String nombre) {
		
		 if (recetasConIngredientes.containsKey(nombre)) {
			 String[] receta = recetasConIngredientes.get(nombre);
			 return receta;
		 }else {
		 	return null;
		 }
	 }
	
	
	
	
	
	
}
