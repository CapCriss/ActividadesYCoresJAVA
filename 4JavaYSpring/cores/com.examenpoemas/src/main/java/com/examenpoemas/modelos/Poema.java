package com.examenpoemas.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "poemas")
public class Poema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El campo es requerido.")
	@Size(min = 5, message = "Debe tener al menos 5 caracteres.")
	private String titulo;
	
	@NotBlank(message = "El campo es requerido.")
	private String autor;
	
	@NotNull(message = "El campo es requerido.")
	@Positive
	private int anio;
	
	@NotBlank(message = "El campo es requerido.")
	@Size(min = 15, message = "Debe tener al menos 15 caracteres.")
	private String letra;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario creador;


	public Poema(Long id, String titulo, String autor, int anio, String letra, Usuario creador) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.anio = anio;
		this.letra = letra;
		this.creador = creador;
	}
	public Poema() {
		super();
		this.id = 0l;
		this.titulo = "";
		this.autor = "";
		this.anio = 0;
		this.letra = "";
		this.creador = null;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public Usuario getCreador() {
		return creador;
	}
	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	
}
