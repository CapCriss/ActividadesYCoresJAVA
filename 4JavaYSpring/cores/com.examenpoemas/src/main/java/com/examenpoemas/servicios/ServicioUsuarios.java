package com.examenpoemas.servicios;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.examenpoemas.modelos.LoginUsuario;
import com.examenpoemas.modelos.Usuario;
import com.examenpoemas.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

	@Autowired
	private RepositorioUsuarios repositorioUsuarios;
	
	public Usuario crearUsuario(Usuario usuario) {
		String hashPasswordString = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		usuario.setPassword(hashPasswordString);
		return this.repositorioUsuarios.save(usuario);
	}
	public List<Usuario> obtenerTodosLosUsuarios(){
		return (List<Usuario>) this.repositorioUsuarios.findAll();
	}
	public Usuario obtenerUsuarioPorId(Long id) {
		return this.repositorioUsuarios.findById(id).orElse(null);
	}
	public Usuario obtenerUsuarioPorEmail(String correo) {
		return this.repositorioUsuarios.findByCorreo(correo).orElse(null);
	}
	public Usuario actualizarUsuario(Usuario usuario) {
		return this.repositorioUsuarios.save(usuario);
	}
	public void eliminarUsuarioPorId(Long id) {
		this.repositorioUsuarios.deleteById(id);
	}
	
	// validaciones de registro (password con confirmarPassword)
	public BindingResult validarRegistro(BindingResult validaciones, Usuario usuario) {
		if (!usuario.getPassword().equals(usuario.getConfirmarPassword())) {
			validaciones.rejectValue("confirmarPassword", "PasswordNoCoincide", "Las contraseñas no coinsiden.");
		}
		return validaciones;
	}
	
	// validar el login si encontramos el email del usuario luego si la contraseña pertece a ese email.
	public BindingResult validarLogin(BindingResult validaciones, LoginUsuario usuario) {
		Usuario usuarioDB = this.obtenerUsuarioPorEmail(usuario.getCorreo());
		if (usuarioDB == null) {
			validaciones.rejectValue("correo", "emailNoRegistrado", "El email ingresado no se encuentra registrado.");
		}else {
			if (!BCrypt.checkpw(usuario.getPassword(), usuarioDB.getPassword())) {
				validaciones.rejectValue("password", "passwordIncorrecta", "Contraseña incorrecta.");
			}
		}
		return validaciones;
	}
}
