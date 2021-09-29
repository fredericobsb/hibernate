package com.example.demo.mapper;

import org.mapstruct.factory.Mappers;

import com.example.demo.dto.UsuarioDto;
import com.example.demo.models.Endereco;
import com.example.demo.models.Usuario;

public class UsuarioMapperImpl implements UsuarioMapper{
	
	private UsuarioMapper mapper = Mappers.getMapper(UsuarioMapper.class);

	@Override
	public Usuario usuarioDtoParaUsuario(UsuarioDto usuarioDto) {
		return null;
	}

	@Override
	public Usuario usuarioParaUsuarioDto(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
