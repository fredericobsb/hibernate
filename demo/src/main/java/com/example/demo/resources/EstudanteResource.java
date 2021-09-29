package com.example.demo.resources;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Curso;
import com.example.demo.models.Estudante;
import com.example.demo.repository.EstudanteRepository;

@RestController
@RequestMapping(path="/estudantes")
public class EstudanteResource {

	@Autowired
	EstudanteRepository estudanteRepository; 
	
	@PostMapping
	public ResponseEntity<Estudante>salvar(@RequestBody Estudante estudante){
		Curso curso = new Curso();
		Set<Estudante>setEstudante = new HashSet<>();	
		setEstudante.add(estudante);
		curso.setLikes(setEstudante);
		Set<Curso>setcurso = new HashSet<>();
		setcurso.add(curso);
		estudante.setLikedCourses(setcurso);
		estudante = this.estudanteRepository.save(estudante);
		return ResponseEntity.ok(estudante);
	}
}
