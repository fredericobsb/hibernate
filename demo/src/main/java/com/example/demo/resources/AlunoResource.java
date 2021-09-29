package com.example.demo.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Aluno;
import com.example.demo.models.Estudante;
import com.example.demo.models.Turma;
import com.example.demo.repository.AlunoRepository;

@RestController
@RequestMapping(path="/alunos")
public class AlunoResource {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@PostMapping
	public ResponseEntity<List<Aluno>>salvar(@RequestBody Aluno aluno){
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Francisco soares");
		
		Turma turma1 = new Turma();
		turma1.setNomeTurma("nome turma 1");
		List<Aluno>listaAlunos = new ArrayList<>();
		
		turma1.setAlunos(listaAlunos);
		
		Turma turma2 = new Turma();
		turma2.setNomeTurma("nome turma 2");
		turma2.setAlunos(listaAlunos);
		
		List<Turma>listaTurmas = new ArrayList<>();
		listaTurmas.add(turma1);
		listaTurmas.add(turma2);
		
		aluno.setTurmas(listaTurmas);
		aluno2.setTurmas(listaTurmas);
		listaAlunos.add(aluno);
		listaAlunos.add(aluno2);
		aluno = this.alunoRepository.save(aluno);
		//aluno2 = this.alunoRepository.save(aluno2);
		
		return ResponseEntity.ok(listaAlunos);
	}

}
