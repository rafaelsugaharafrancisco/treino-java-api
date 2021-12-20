package br.com.alura.rodizi_de_veiculos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alura.rodizi_de_veiculos.models.Usuario;
import br.com.alura.rodizi_de_veiculos.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	private UsuarioRepository repository;
	
	@Autowired
	public AutenticacaoService(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByEmail(username);
		
		if (!usuario.isPresent()) {
			throw new UsernameNotFoundException("UserName/Password inválidos");
		}
		
		return usuario.get();
	}

}
