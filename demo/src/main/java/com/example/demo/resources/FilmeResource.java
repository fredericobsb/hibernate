package com.example.demo.resources;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Artista;
import com.example.demo.models.ArtistaFilme;
import com.example.demo.models.Filme;
import com.example.demo.models.Person;
import com.example.demo.repository.ArtistaRepository;
import com.example.demo.repository.FilmRepository;

@RestController
@RequestMapping(path="/filmes")
public class FilmeResource {
	
	@Autowired
	FilmRepository filmeRepository;
	
	@Autowired
	ArtistaRepository artistaRepository;

	@PostMapping
	public ResponseEntity<Filme>save(@RequestBody Artista artista){
		
		artista = artistaRepository.save(artista);
		
		Artista artista2 = new Artista();
		artista2.setNome("artista-2");
		artista2 = artistaRepository.save(artista2);
		
		Filme filme = new Filme();
		filme.setNome("filme");
	    ArtistaFilme artistaFilme1 = new ArtistaFilme();
	    artistaFilme1.setFilme(filme); // Referencia de memoria.
	    artistaFilme1.setArtista(artista);
	    artistaFilme1.setNome("nome-artistico-1");
		
	    ArtistaFilme artistaFilme2 = new ArtistaFilme();
	    artistaFilme2.setFilme(filme); // Referencia de memoria.
	    artistaFilme2.setArtista(artista2);
	    artistaFilme2.setNome("nome-artistico-2");

	    Collection<ArtistaFilme> elenco = Arrays.asList(artistaFilme1, artistaFilme2);
	    filme.setArtistaFilmeList(elenco);
	    filmeRepository.save(filme);
		return new ResponseEntity<Filme>(filme, HttpStatus.OK);
	}
}
