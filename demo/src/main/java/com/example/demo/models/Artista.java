package com.example.demo.models;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter	
@Entity
public class Artista {

  @Id
  @GeneratedValue
  private Long id;
  private String nome;

  @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
  private Collection<ArtistaFilme> artistaFilmeList;

}

