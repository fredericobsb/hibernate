package com.example.demo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Aluno implements Serializable {
	
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
	
    private String nome;
	
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Turma.class)
    @JoinTable(name="ALUNO_TURMA", joinColumns=@JoinColumn(name="ALUNO_ID"),inverseJoinColumns=@JoinColumn(name="TURMA_ID"))
    private List<Turma> turmas;
}
