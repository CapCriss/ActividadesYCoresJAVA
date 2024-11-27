package com.examenpoemas.modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El campo es obligatorio.")
	@Size(min = 3, message = "Debe tener al menos 3 caracteres.")
	private String nombre;
	
	@NotBlank(message = "El campo es obligatorio.")
	@Size(min = 3, message = "Debe tener al menos 3 caracteres.")
	private String apellido;
	
	@Column(unique = true) // que no exista en la db
	@NotBlank(message = "El campo es obligatorio.")
	@Email(message = "Debe ser un correo electrónico válido.")
	private String correo;
	
	@NotBlank(message = "El campo es obligatorio.")
	@Size(min = 8, message = "Debe tener al menos 8 caracteres.")
	private String password;
	
	@Transient
	private String confirmarPassword;
	
	
	@OneToMany(mappedBy = "creador")
	private List<Poema> poemas;
	
	
	public Usuario(Long id, String nombre, String apellido, String correo, String password, String confirmarPassword, List<Poema> poemas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
		this.confirmarPassword = confirmarPassword;
		this.poemas = poemas;
	}
	
	public Usuario() {
		super();
		this.id = 0l;
		this.nombre = "";
		this.apellido = "";
		this.correo = "";
		this.password = "";
		this.confirmarPassword = "";
		this.poemas = null;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

	public List<Poema> getPoemas() {
		return poemas;
	}

	public void setPoemas(List<Poema> poemas) {
		this.poemas = poemas;
	}
	
	
}
