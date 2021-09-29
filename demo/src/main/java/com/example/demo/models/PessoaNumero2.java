package com.example.demo.models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PessoaNumero2 {

	 @Id
	  @GeneratedValue
	  private Long id;
	  
	  private Long cpf;
	  
	  private String nome;
	  
	  @OneToMany(mappedBy = "pessoaNumero2", cascade = CascadeType.ALL)
	  private Collection<EmpresaPessoa> empresaPessoaList;
	  
}
