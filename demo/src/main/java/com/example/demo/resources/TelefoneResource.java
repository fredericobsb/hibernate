package com.example.demo.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Telefone;
import com.example.demo.models.Telefone;
import com.example.demo.repository.TelefoneRepository;

@RestController
@RequestMapping(path="/telefones")
public class TelefoneResource {
	
	private TelefoneRepository telefoneRepository;
	
	public TelefoneResource(TelefoneRepository telefoneRepository) {
		super();
		this.telefoneRepository = telefoneRepository;
	}
	
	@PostMapping
	public ResponseEntity<Telefone>save(@RequestBody Telefone telefone){
		telefoneRepository.save(telefone);
		return new ResponseEntity<Telefone>(telefone, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Telefone>>getAll(){
		List<Telefone>telefones = new ArrayList<Telefone>();
		telefones = telefoneRepository.findAll();
		return new ResponseEntity<List<Telefone>>(telefones, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Optional<Telefone>>getById(@PathVariable Integer id){
		Optional<Telefone>telefone = null;
		try {
			telefone = telefoneRepository.findById(id);
			return new ResponseEntity<Optional<Telefone>>(telefone, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Optional<Telefone>>(telefone, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Optional<Telefone>> deleteById(@PathVariable Integer id){
		try {
			telefoneRepository.deleteById(id);
			return new ResponseEntity<Optional<Telefone>>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Optional<Telefone>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Telefone> update (@PathVariable Integer id, @RequestBody Telefone newTelefone){
		return (ResponseEntity<Telefone>) telefoneRepository.findById(id)
			.map(telefone -> {
				telefone.setNumero(newTelefone.getNumero());
				Telefone TelefoneUpdated = telefoneRepository.save(telefone);
				return ResponseEntity.ok().body(TelefoneUpdated);
			}).orElse(ResponseEntity.notFound().build());
	}
	
	
}
