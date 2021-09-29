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
public class ArtistaFilme {

  @Id
  @GeneratedValue
  private Long id;
  private String nome;

  @ManyToOne
  @JoinColumn(name = "filme_id")
  private Filme filme;

  @ManyToOne
  @JoinColumn(name = "artista_id")
  private Artista artista;

  // getters e setters

}

