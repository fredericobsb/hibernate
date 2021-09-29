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
import com.example.demo.models.TipoEmpresa;
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
		
		empresa.setCnpj("12345678999");
		empresa.setNomeEmpresa("nome empresa Minime");
		empresa.setRazaoSocial("Razao social minime");
		empresa.setTipoEmpresa(TipoEmpresa.CONCESSIONARIA);
		empresa = empresaRepository.save(empresa);
		
		//Empresa empresa2 = new Empresa();
		//empresa2.setNome("empresa 2 nome");
		//empresa2 = this.empresaRepository.save(empresa2);
		
		Collection<EmpresaPessoa> empresasPessoas = null;
		
		PessoaNumero2 pessoaNumero2 = new PessoaNumero2();
		pessoaNumero2.setCpf(89214153191L);
		pessoaNumero2.setNome("Frederico lopes ramos");
		
		/* Para salvar 1 pesssoa, o responsavel pela empresa*/
		EmpresaPessoa empresaPessoa = new EmpresaPessoa();
		empresaPessoa.setEmpresa(empresa);
		empresaPessoa.setPessoaNumero2(pessoaNumero2);// Referencia de memoria.
		empresaPessoa.setTipoPessoa("RESPONSAVEL");
		
		 empresasPessoas = Arrays.asList(empresaPessoa);
		 pessoaNumero2.setEmpresaPessoaList(empresasPessoas);
		 pessoaNumero2Repository.save(pessoaNumero2);
		 
		 /*para salvar varias pessoas, os socios da empresa*/
		 PessoaNumero2 socio1 = new PessoaNumero2();
		 socio1.setCpf(12345678L);
		 socio1.setNome("Francisco do c sharp");
		 EmpresaPessoa empresaPessoa2 = new EmpresaPessoa();
		 empresaPessoa2.setEmpresa(empresa);
		 empresaPessoa2.setPessoaNumero2(socio1);
		 empresaPessoa2.setTipoPessoa("SOCIO");
		 empresasPessoas = Arrays.asList(empresaPessoa2);
		 socio1.setEmpresaPessoaList(empresasPessoas);
		 pessoaNumero2Repository.save(socio1);
		 
		 PessoaNumero2 socio2 = new PessoaNumero2();
		 socio2.setCpf(12345678L);
		 socio2.setNome("Zé Java nao dorme da silva");
		 EmpresaPessoa empresaPessoa3 = new EmpresaPessoa();
		 empresaPessoa3.setEmpresa(empresa);
		 empresaPessoa3.setPessoaNumero2(socio2);
		 empresaPessoa3.setTipoPessoa("SOCIO");
		 empresasPessoas = Arrays.asList(empresaPessoa3);
		 socio2.setEmpresaPessoaList(empresasPessoas);
		 pessoaNumero2Repository.save(socio2);
		 
		 PessoaNumero2 socio3 = new PessoaNumero2();
		 socio3.setCpf(344565678L);
		 socio3.setNome("Zé Angular nao dorme da dia");
		 EmpresaPessoa empresaPessoa4 = new EmpresaPessoa();
		 empresaPessoa4.setEmpresa(empresa);
		 empresaPessoa4.setPessoaNumero2(socio3);
		 empresaPessoa4.setTipoPessoa("SOCIO");
		 empresasPessoas = Arrays.asList(empresaPessoa4);
		 socio3.setEmpresaPessoaList(empresasPessoas);
		 pessoaNumero2Repository.save(socio3);
		 
		 PessoaNumero2 socio4 = new PessoaNumero2();
		 socio4.setCpf(66665678L);
		 socio4.setNome("Zé Eclipse nao dorme da noite");
		 EmpresaPessoa empresaPessoa5 = new EmpresaPessoa();
		 empresaPessoa5.setEmpresa(empresa);
		 empresaPessoa5.setPessoaNumero2(socio4);
		 empresaPessoa5.setTipoPessoa("SOCIO");
		 empresasPessoas = Arrays.asList(empresaPessoa5);
		 socio4.setEmpresaPessoaList(empresasPessoas);
		 pessoaNumero2Repository.save(socio4);
		return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
	}
}
