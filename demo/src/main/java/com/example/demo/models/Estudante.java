package com.example.demo.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties
@Getter
@Setter
@Entity
public class Estudante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

	
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
	  name = "course_like", 
	  joinColumns = @JoinColumn(name = "estudante_id"), 
	  inverseJoinColumns = @JoinColumn(name = "curso_id"))
    Set<Curso> likedCourses;
}
