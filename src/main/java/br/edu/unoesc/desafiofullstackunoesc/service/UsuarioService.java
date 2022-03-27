package br.edu.unoesc.desafiofullstackunoesc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;
import br.edu.unoesc.desafiofullstackunoesc.domain.Perfil;
import br.edu.unoesc.desafiofullstackunoesc.domain.Usuario;
import br.edu.unoesc.desafiofullstackunoesc.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
	@Autowired
	private UsuarioRepository repository;

	@Transactional(readOnly = true)
	public br.edu.unoesc.desafiofullstackunoesc.domain.Usuario buscarPorEmail(String email) {
		return repository.findByEmail(email);
	}

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = buscarPorEmail(username);
		return new User(usuario.getEmail(), usuario.getSenha(),
				AuthorityUtils.createAuthorityList(getAutorities(usuario.getPerfis())));
	}

	private String[] getAutorities(java.util.List<Perfil> perfis) {
		String[] authorities = new String[perfis.size()];
		for (int i = 0; i < perfis.size(); i++) {
			authorities[i] = perfis.get(i).getDesc();
		}
		return authorities;
	}
}
