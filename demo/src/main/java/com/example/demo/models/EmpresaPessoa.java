package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EmpresaPessoa {

	  @Id
	  @GeneratedValue
	  private Long id;
	  
	  @ManyToOne
	  @JoinColumn(name = "empresa_id")
	  private Empresa empresa;
	  
	  @ManyToOne
	  @JoinColumn(name = "pessoaa_id")
	  private PessoaNumero2 pessoaNumero2;
	  
	  private String tipoPessoa;

}
