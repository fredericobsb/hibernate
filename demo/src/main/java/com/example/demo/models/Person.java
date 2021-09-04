package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person {

	@Id
	@GeneratedValue
	@Column(name="person_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	/*
	 * @OneToMany(mappedBy="person", cascade = ...)
	 * 
	 * cascade = CascadeType.PERSIST => erro de detached.
	 * CascadeType.ALL => detached entity passed to persist: com.example.demo.models.Telefone
	 * 		==> Esse erro deu quando tentou persistir telefones com id. Retirou o id e persistiu.
	 * 
	 * CascadeType.MERGE => salva a Person, mas nao salva os telefones
	 *CascadeType.DETACH => salva a Person, mas nao salva os telefones
	 *
	 *@OneToMany(mappedBy="person") => persiste o Person, mas nao os telefones
	 * 
	 * 
	 * */
	@JsonManagedReference
	@OneToMany(mappedBy="person",cascade = CascadeType.PERSIST)
	private List<Telefone>listaTelefones;
	
	public Person() {
		
	}

	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
}
