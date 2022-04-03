package br.edu.unoesc.desafiofullstackunoesc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.unoesc.desafiofullstackunoesc.dao.UsuarioRepository;
import br.edu.unoesc.desafiofullstackunoesc.domain.Usuario;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Transactional(readOnly = true)
	public Usuario buscarPorEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = buscarPorEmail(username);
		return new User(usuario.getEmail(), usuario.getSenha(), AuthorityUtils.NO_AUTHORITIES);
	}

	@Transactional(readOnly = false)
	public void salvarUsuario(Usuario usuario) throws Exception {
		String crypt = new BCryptPasswordEncoder().encode(usuario.getSenha());
		usuario.setSenha(crypt);
		repository.save(usuario);
	}

	@Transactional(readOnly = true)
	public Usuario buscarPorId(Long id) {

		return repository.findById(id).get();
	}
}
