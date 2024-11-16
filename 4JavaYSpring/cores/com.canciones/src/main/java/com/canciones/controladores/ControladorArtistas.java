package com.canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.canciones.modelos.Artista;
import com.canciones.modelos.Cancion;
import com.canciones.servicios.ServicioArtistas;

import jakarta.validation.Valid;


@Controller
public class ControladorArtistas {
	
	@Autowired
	ServicioArtistas servicioArtistas;
	
	
	// METODO OBTENER TODOS LOS ARTISTAS
	@GetMapping("/artistas")
	public String desplegarArtistas(Model modelo) {
		modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
		return "artistas.jsp";
	}
	// METODO OBTENER DETALLE DE UN ARTISTA POR ID
	@GetMapping("/artistas/detalle/{id}")
	public String mostrarDetalleArtista(@PathVariable("id") Long id, Model modelo) {
		modelo.addAttribute("artista", servicioArtistas.obtenerArtistaPorId(id));
		modelo.addAttribute("cancionArtista", new Cancion());
		return "detalleArtista.jsp";
	}
	// AGREGAR ARTISTA
	@GetMapping("/artistas/formulario/agregar" )
	public String formularioAgregarArtista(Model modelo) {
		modelo.addAttribute("artista", new Artista());
		return "agregarArtista.jsp";
	}
	
	@PostMapping("/artistas/procesa/agregar") 
	public String procesarAgregarArtista(@Valid @ModelAttribute("artista") Artista artista, BindingResult validaciones) {
		if (validaciones.hasErrors()) {
			return "agregarArtista.jsp";
		}
		servicioArtistas.agregarArtista(artista);
		return "redirect:/artistas";
		 
		
	}
}
