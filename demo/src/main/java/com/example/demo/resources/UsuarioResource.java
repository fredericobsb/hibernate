package com.example.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Endereco;
import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

	private final UsuarioRepository usuarioRepository;
	
	public UsuarioResource(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@PostMapping
	public ResponseEntity<Usuario>save(@RequestBody Usuario usuario){
		Endereco endereco = usuario.getEndereco();
		endereco.setUsuario(usuario);
		usuario = this.usuarioRepository.save(usuario);
		
		return ResponseEntity.ok(usuario);
	}
}
