package com.example.demo.models;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Arquivo {

	@GeneratedValue
	@Id
	@Column(name="arquivo_id")
	private Long id;
	
	@Lob
	@Column(name="arquivo_conteudo")
	private byte[]  bytes;
}
