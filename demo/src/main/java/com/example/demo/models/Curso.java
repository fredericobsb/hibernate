package com.example.demo.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties
@Entity
@Getter
@Setter
public class Curso implements Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		@Id
	    @GeneratedValue(strategy= GenerationType.AUTO)	
	    Long id;

		
	    @ManyToMany
	    Set<Estudante> likes;
}
