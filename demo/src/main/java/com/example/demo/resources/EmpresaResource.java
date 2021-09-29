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

import com.example.demo.models.ArtistaFilme;
import com.example.demo.models.Empresa;
import com.example.demo.models.EmpresaPessoa;
import com.example.demo.models.PessoaNumero2;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.PessoaNumero2Repository;

@RestController
@RequestMapping(value="/empresas")
public class EmpresaResource {

	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	PessoaNumero2Repository pessoaNumero2Repository;
	
	@PostMapping
	public ResponseEntity<Empresa>save(@RequestBody Empresa empresa){
		
		empresa = empresaRepository.save(empresa);
		
		Empresa empresa2 = new Empresa();
		empresa2.setNome("empresa 2 nome");
		empresa2 = this.empresaRepository.save(empresa2);
		
		PessoaNumero2 pessoaNumero2 = new PessoaNumero2();
		pessoaNumero2.setCpf(89214153191L);
		pessoaNumero2.setNome("Frederico lopes ramos");
		
		EmpresaPessoa empresaPessoa = new EmpresaPessoa();
		empresaPessoa.setEmpresa(empresa);
		empresaPessoa.setPessoaNumero2(pessoaNumero2);// Referencia de memoria.
		empresaPessoa.setTipoPessoa("RESPONSAVEL");
		
		EmpresaPessoa empresaPessoa2 = new EmpresaPessoa();
		empresaPessoa2.setEmpresa(empresa2);
		empresaPessoa2.setPessoaNumero2(pessoaNumero2);
		empresaPessoa2.setTipoPessoa("SOCIO");
		
		 Collection<EmpresaPessoa> empresasPessoas = Arrays.asList(empresaPessoa, empresaPessoa2);
		 pessoaNumero2.setEmpresaPessoaList(empresasPessoas);
		 pessoaNumero2Repository.save(pessoaNumero2);
		
		return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
	}
}
