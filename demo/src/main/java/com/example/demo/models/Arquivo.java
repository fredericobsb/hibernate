package com.example.demo.models;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.assertj.core.internal.Bytes;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Arquivo {

	@GeneratedValue
	@Id
	@Column(name="arquivo_id")
	private Long id;
	
	@Lob
	@Column(name="arquivo_conteudo")
	private byte[]  bytes;

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
