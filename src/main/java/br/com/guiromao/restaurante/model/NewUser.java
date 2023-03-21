package br.com.guiromao.restaurante.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

public class NewUser extends User {

    private Usuario usuario;

    public NewUser(Usuario usuario) {
        super(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }


}
