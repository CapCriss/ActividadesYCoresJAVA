package com.canciones.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.canciones.modelos.Artista;

@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long>{

	//OBTENER TODOS LOS ARTISTAS
	
	List<Artista> findAll();
}
