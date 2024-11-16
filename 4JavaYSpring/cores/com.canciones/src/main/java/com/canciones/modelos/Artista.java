package com.canciones.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "artistas")
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Debes agregar el nombre del artista.")
	private String nombre;
	private String apellido;
	private String biografia;
	private LocalDate fechaCreacion;
	private LocalDate fechaActualizacion;
	@OneToMany(mappedBy = "artista")
	private List<Cancion> canciones;
	public Artista(Long id, String nombre, String apellido, String biografia, LocalDate fechaCreacion,
			LocalDate fechaActualizacion, List<Cancion> canciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.biografia = biografia;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.canciones = canciones;
	}
	
	public Artista() {
		super();
		this.id = 0l;
		this.nombre = "";
		this.apellido = "";
		this.biografia = "";
		this.fechaCreacion = LocalDate.now();
		this.fechaActualizacion = LocalDate.now();
		this.canciones = new ArrayList<Cancion>(); // NO LIST<>()?
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

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDate fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	@PrePersist
	private void onCreate() {
		this.fechaCreacion = LocalDate.now(); // SON LAS MISMAS HASTA QUE SE ACTUALICE UNA CANCION
		this.fechaActualizacion = LocalDate.now();
	}
	// PARA ACTUALIZAR LA FECHA 
	@PreUpdate
	private void onUpdate() {
		this.fechaActualizacion = LocalDate.now();
	}

	public List<Cancion> getCancionesArtista() {
		return canciones;
	}

	public void setCancionesArtista(List<Cancion> cancionesArtista) {
		this.canciones = cancionesArtista;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
	

}
