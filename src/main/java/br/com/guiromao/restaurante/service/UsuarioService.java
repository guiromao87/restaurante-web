package br.com.guiromao.restaurante.service;

import br.com.guiromao.restaurante.model.Usuario;
import br.com.guiromao.restaurante.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository.findByLogin(username);
        return new User(
            usuario.getUsername(),
            usuario.getPassword(),
            true,
            true,
            true,
            true,
            usuario.getAuthorities()
        );
    }
}
