package com.examenpoemas.controladores;

import java.util.List;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
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

import com.examenpoemas.modelos.Poema;
import com.examenpoemas.servicios.ServicioPoemas;
import com.examenpoemas.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorPoemas {
	
	@Autowired
	ServicioPoemas servicioPoemas;
	
	@Autowired
	ServicioUsuarios servicioUsuarios;
	
	@GetMapping("/poemas") // TODOS LOS POEMAS
	public String mostrarTodosLosPoemas(HttpSession sesion, Model modelo) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if (idUsuario == null) {
			return "redirect:/";
		}
		List<Poema> poemas = this.servicioPoemas.obtenerTodosLosPoemas();
		modelo.addAttribute("poemas", poemas);
		return "poemas.jsp";
	}
	
	@GetMapping("/form/agregar") // FORMULARIO PARA AGREGAR POEMA
	public String agregarPoema(HttpSession sesion, Model modelo) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/"; // SI NOMBRE COMPLETO NO EXISTE NO PODRÁ CREAR UN POEMA
		}
		modelo.addAttribute("poema", new Poema());
		return "agregarPoema.jsp";
	}
	@GetMapping("/form/editar/{id}") // FORMUALARIO PARA EDITAR POEMA
	public String editarPoema(@PathVariable("id") Long id, HttpSession sesion, Model modelo) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/"; // SI NOMBRE COMPLETO NO EXISTE NO PODRÁ EDITAR EL POEMA
		}
		modelo.addAttribute("poema", this.servicioPoemas.obtenerPoemaPorId(id));
		return "editarPoema.jsp";
	}
	
	// PROCESO DE INFORMACION (POST/PUTMAPPINGS)
	
	@PostMapping("/guardar") //PROCESAR/GUARDAR POEMA
	public String guardarPoema(HttpSession sesion, @Valid @ModelAttribute("poema") Poema poema, BindingResult validaciones) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/"; // SI NOMBRE COMPLETO NO EXISTE NO PODRÁ GUARDAR EL POEMA
		}
		if (validaciones.hasErrors()) {
			return "agregarPoema.jsp";
		}
		this.servicioPoemas.crearPoema(poema);
		return "redirect:/poemas";
	}
	@PutMapping("/actualizar/{id}") // PROCESAR EDICION DEL POEMA
	public String actualizarPoema(@PathVariable("id") Long id, HttpSession sesion, @Valid @ModelAttribute("poema") Poema poema, BindingResult validaciones) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/"; // SI NOMBRE COMPLETO NO EXISTE NO PODRÁ EDITAR EL POEMA
		}
		if (validaciones.hasErrors()) {
			return "editarPoema.jsp";
		}
		this.servicioPoemas.actualizarPoema(poema);
		return "redirect:/poemas";
		
	}
	@DeleteMapping("/eliminar/{id}")
	// ELIMINAR UN POEMA
	public String eliminarPoema(@PathVariable("id") Long id, HttpSession sesion) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/"; // SI NOMBRE COMPLETO NO EXISTE NO PODRÁ ELIMINAR EL POEMA
		}
		this.servicioPoemas.eliminarPoemaPorId(id);
		return "redirect:/poemas";
	}
	
	
	@GetMapping("/detalle/{id}") // MOSTRAR DETALLE DE POEMA
	public String detallePoema(@PathVariable("id") Long id, HttpSession sesion, Model modelo) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/"; // SI NOMBRE COMPLETO NO EXISTE NO PODRÁ VER DETALLE DEL POEMA
		}
		modelo.addAttribute("poema", this.servicioPoemas.obtenerPoemaPorId(id));
		return "detallePoema.jsp";
	}
}
