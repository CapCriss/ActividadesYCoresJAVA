package com.canciones.servicios;
import com.canciones.repositorios.RepositorioCanciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canciones.modelos.Cancion;

@Service
public class ServicioCanciones {
	
	@Autowired
	private RepositorioCanciones repositorioCanciones;
	
	
	// ME DEVUELVE TODAS LAS CANCIONES EN LA BD
	public List<Cancion> obtenerTodasLasCanciones(){
		return (List<Cancion>)repositorioCanciones.findAll();
	}
	
	// ME DEVUELVE CANCION POR ID DE LA BD
	public Cancion obtenerCancionPorId(Long id) {
		return repositorioCanciones.findById(id).orElse(null);
	}
	
	// AGREGAR CANCION A LA BD
	public Cancion agregarCancion(Cancion cancion) {
		return this.repositorioCanciones.save(cancion);
	}
	
	// ACTUALIZAR CANCION 
	public Cancion actualizaCancion(Cancion cancion) {
		return this.repositorioCanciones.save(cancion);
	}
	
	// ELIMINAR CANCION POR
	public void eliminarCancion(Long id) {
		this.repositorioCanciones.deleteById(id);
	}

}
