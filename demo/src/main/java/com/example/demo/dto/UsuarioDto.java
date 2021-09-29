package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

	private Long id;
	private String nome;
	private EnderecoDto enderecoDto;
}
