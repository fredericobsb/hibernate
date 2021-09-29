package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.models.Usuario;

@Mapper
public interface UsuarioMapper {

	Usuario usuarioDtoParaUsuario(UsuarioDto usuarioDto);
	Usuario usuarioParaUsuarioDto(Usuario usuario);
}
