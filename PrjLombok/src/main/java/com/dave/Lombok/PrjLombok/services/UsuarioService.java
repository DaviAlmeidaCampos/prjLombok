package com.dave.Lombok.PrjLombok.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dave.Lombok.PrjLombok.entities.Usuario;
import com.dave.Lombok.PrjLombok.repositories.UsuarioRepositorio;

public class UsuarioService {
	
	
	public class Service {

		private final UsuarioRepositorio usuariorepositorio;

		@Autowired
		public Service(UsuarioRepositorio usuariorepositorio) {
			this.usuariorepositorio = usuariorepositorio;
		}

		// preparando as buscas por id
		public Usuario findUsuarioById(Long id) {
			Optional<Usuario> Usuario = usuariorepositorio.findById(id);
			return Usuario.orElse(null);
		}

		// preparando a busca geral
		public List<Usuario> findAllUsuario() {
			return usuariorepositorio.findAll();
		}

		// salvando o Jogo
		public Usuario insertUsuario(Usuario usuario) {
			return usuariorepositorio.save(usuario);
		}

		// fazendo o update do jogo com o optional
		public Usuario updateUsuario(Long id, Usuario novoUsuario) {
			Optional<Usuario> usuarioOptional = usuariorepositorio.findById(id);
			if (usuarioOptional.isPresent()) {
				Usuario usuarioExistente = usuarioOptional.get();
				usuarioExistente.setNome(novoUsuario.getNome());
				usuarioExistente.setEmail(novoUsuario.getEmail());
				return usuariorepositorio.save(usuarioExistente);
			} else {
				return null;
			}
		}

		// deletando o update do usuario com o optional
		public boolean deleteUsuario(Long id) {
			Optional<Usuario> usuarioExistente = usuariorepositorio.findById(id);
			if (usuarioExistente.isPresent()) {
				usuariorepositorio.deleteById(id);
				return true;
			} else {
				return false;
			}
		}

	}
}
