package com.librosyautores.controladores;


import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ControladorLibros {
	
	//ATRIBUTOS
	private static HashMap<String, String> listaLibros = new HashMap<String, String>();
	
	//CONTRUCTOR - LLENANDO EL HASHMAP
	public ControladorLibros() {
		listaLibros.put("Odisea", "Homero");	
		listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
		listaLibros.put("El Código Da Vinci", "Dan Brown");		
		listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
		listaLibros.put("El Hobbit", "J.R.R. Tolkien");	
		listaLibros.put("El alquimista", "Paulo Coelho");	
	

	}
	
	
	//METODOS / FUNCIONES
	
	//probar servidor
	/*
	@GetMapping("/saludo")
	public String inicio() {
		return "hola spring boot! libros";
	}
	*/
	
	// obtenerTodosLosLibros(): Método que responde a la ruta /libros y retorna un JSP llamado libros.jsp para cargar todos los libros dentro de la lista
	@GetMapping("/libros")
	public String obtenerTodosLosLibros(Model modelo) {
		 // System.out.println("alo alo");
		modelo.addAttribute("libros", listaLibros);
		return "libros.jsp";
	}
	
	// obtenerInformacionDeLibro(): Método que responde a la ruta /libros/{nombre} y retorna la información de un libro en específico, devuelve el nombre del libro y su autor al JSP llamado detalleLibro.jsp.. En caso de que el libro no exista en la lista devolver un mensaje como el siguiente:  «El libro no se encuentra en nuestra lista.»
	
	@GetMapping("/libros/{nombre}")
	public String obtenerLibroPorNombre(Model modelo, @PathVariable(value = "nombre") String nombre) {
		if(listaLibros.containsKey(nombre)) {
            String autor = listaLibros.get(nombre);
            modelo.addAttribute("nombre", nombre);
            modelo.addAttribute("existe", true);
             
        }else {
        	
			modelo.addAttribute("existe", false);
		}
        return "detalleLibro.jsp";
    }
	
	@GetMapping("/libros/formulario")
	public String formularioLibro() {
		
		return "formularioLibros.jsp";
	}
	
	@PostMapping("/procesa/libro")
	public String procesaLibro(@RequestParam String nombreLibro, @RequestParam String autorLibro) {
		listaLibros.put(nombreLibro, autorLibro);
		return "redirect:/libros";
	}
		
		
	




	public static HashMap<String, String> getListaLibros() {
		return listaLibros;
	}


	public static void setListaLibros(HashMap<String, String> listaLibros) {
		ControladorLibros.listaLibros = listaLibros;
	}
	
	
}

