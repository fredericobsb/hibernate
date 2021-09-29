package com.example.demo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Notebook;
import com.example.demo.models.Pessoa;
import com.example.demo.repository.PessoaRepository;

@RestController
@RequestMapping(path="/pessoas")
public class PessoaResource {
	
	@Autowired
	PessoaRepository pessoaRepository;

	@PostMapping
	public ResponseEntity<Pessoa>save(@RequestBody Pessoa pessoa){
		pessoa.setCompanyName("nome da companhia tabajara");
		List<Notebook>notebooks = new ArrayList<>();
		Notebook note = new Notebook();
		note.setHdSpaceTotal(40);
		note.setRamMemoryTotal(400);
		note.setSerialNumber("123");
		
		Notebook note2 = new Notebook();
		note2.setHdSpaceTotal(60);
		note2.setRamMemoryTotal(600);
		note2.setSerialNumber("455");
		
		notebooks.add(note);
		notebooks.add(note2);
		
		pessoa.setNotebooks(notebooks);
		pessoaRepository.save(pessoa);
		
		
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}
}
