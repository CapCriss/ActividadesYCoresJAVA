package com.canciones.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.canciones.modelos.Artista;
import com.canciones.modelos.Cancion;
import com.canciones.servicios.ServicioArtistas;
import com.canciones.servicios.ServicioCanciones;


import jakarta.validation.Valid;

@Controller
public class Canciones {
	
	@Autowired
	private ServicioCanciones servicioCanciones;
	@Autowired
	private ServicioArtistas servicioArtistas;

	
	
	
	// METODOS
		//MOSTRAR TODAS LAS CANCIONES
	@GetMapping("/canciones")
	public String mostrarCanciones(Model modelo) {
		
		modelo.addAttribute("canciones", servicioCanciones.obtenerTodasLasCanciones());
		return "canciones.jsp";
	}
	
		// MOSTRAR DETALLE DE CANCION
	@GetMapping("/canciones/detalle/{id}")
	public String mostrarDetalleCancion(@PathVariable("id") Long id, Model modelo) {
		modelo.addAttribute("cancion", servicioCanciones.obtenerCancionPorId(id));
		return "detalleCancion.jsp";
	}
	
		// AGREGAR CANCION ID
	@GetMapping("/canciones/formulario/agregar" )
	public String formularioAgregarCancion(Model modelo) {
		modelo.addAttribute("cancion", new Cancion());
		modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
		return "agregarCancion.jsp";
	}
		// AGREGAR LA CANCION A LA BD CON LAS VALIDACIONES
	@PostMapping("/canciones/procesa/agregar") 
	public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, Artista artista, BindingResult validaciones) {
		if (validaciones.hasErrors()) {
			return "agregarCancion.jsp";
		}
		servicioCanciones.agregarCancion(cancion);
		return "redirect:/canciones";
		 
		
	}
	// ACTUALIZAR CANCION ID
	
	@GetMapping("/canciones/formulario/editar/{id}")
	public String formularioEditarCancion(@PathVariable("id") Long id, @ModelAttribute("cancion") Cancion cancion, Model modelo) {
		
		Cancion editarCanciones = this.servicioCanciones.obtenerCancionPorId(id);
		modelo.addAttribute("cancion", editarCanciones);
		
		
		return "editarCancion.jsp";
	}
	
	// ACTUALIZAR LA CANCION A LA BD CON LAS VALIDACIONES
	@PutMapping("/canciones/procesa/editar/{id}") // /{idCancion}?? 
	public String procesarEditarCancion(@PathVariable("id") Long id, @Valid  @ModelAttribute("cancion") Cancion cancion, BindingResult validaciones) {
		if (validaciones.hasErrors()) {
			return "editarCancion.jsp";
		}
		servicioArtistas.obtenerArtistaPorId(id);
		servicioCanciones.actualizaCancion(cancion);
		return "redirect:/canciones";
		
		
	}
	@DeleteMapping("/canciones/eliminar/{id}")
	public String procesarEliminarCancion(@PathVariable("id") Long id) {
		servicioCanciones.eliminarCancion(id);
		return "redirect:/canciones";
	}

	
	
}
