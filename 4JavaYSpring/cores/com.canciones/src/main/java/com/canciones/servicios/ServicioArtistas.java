package com.canciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canciones.modelos.Artista;
import com.canciones.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {

	@Autowired
	RepositorioArtistas repositorioArtistas;
	
	//DEVUELVE LISTA DE ARTISTAS DE LA BD
	public List<Artista> obtenerTodosLosArtistas(){
		return (List<Artista>)repositorioArtistas.findAll();
	}
	
	//DEVUELVE UN ARTISTA POR ID DE LA BD
	public Artista obtenerArtistaPorId(Long id) {
		return repositorioArtistas.findById(id).orElse(null);
	}
	
	// AGREGAR ARTISTA A LA BD
	public Artista agregarArtista(Artista artista) {
		return this.repositorioArtistas.save(artista);
	}
}
