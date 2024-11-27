package com.examenpoemas.controladores;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.examenpoemas.modelos.LoginUsuario;
import com.examenpoemas.modelos.Usuario;
import com.examenpoemas.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {
	
	@Autowired
	private ServicioUsuarios servicioUsuarios;
	
	@GetMapping("/") // FORMULARIO PARA LOGEAR QUE SEA EL INICIO
	public String formularioLogin(Model modelo) {
		modelo.addAttribute("loginUsuario", new LoginUsuario());
		return "login.jsp";
	}
	@GetMapping("/registro") // FORMULARIO PARA REGISTRAR
	public String formularioRegistro(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return "register.jsp";
	}
	@GetMapping("/logout") // CIERRE DE SESION *
	public String cierreSesion( HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/";
	}
	
	// PROCESO DE INFORMACIÓN (POSTMAPPINGS)
	@PostMapping("/login") // PROCESAR INFORMACIÓN DEL LOGIN
	public String inicioSesion(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario, BindingResult validaciones, Model modelo, HttpSession sesion) {
		servicioUsuarios.validarLogin(validaciones, loginUsuario);
		if (validaciones.hasErrors()) {
			return "login.jsp";
		}
		Usuario usuario = this.servicioUsuarios.obtenerUsuarioPorEmail(loginUsuario.getCorreo());
		sesion.setAttribute("nombreCompleto", usuario.getNombre() + " " + usuario.getApellido()); // POR SI LO LLEGARA A NECESITAR
		sesion.setAttribute("idUsuario", usuario.getId());
		return "redirect:/poemas";
		
	}
	@PostMapping("/register") // PROCESAR INFORMACIÓN DEL REGISTRO
	public String registro(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult validaciones, Model modelo, HttpSession sesion) {
		this.servicioUsuarios.validarRegistro(validaciones, usuario);
		if (validaciones.hasErrors()) {
			return "register.jsp";
		}
		Usuario usuario2 = this.servicioUsuarios.crearUsuario(usuario);
		sesion.setAttribute("nombreCompleto", usuario2.getNombre() + " " + usuario2.getApellido());
		sesion.setAttribute("idUsuario", usuario2.getId());
		return "poemas.jsp";
	}
	

}
