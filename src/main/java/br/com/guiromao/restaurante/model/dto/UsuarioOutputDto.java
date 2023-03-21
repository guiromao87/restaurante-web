package br.com.guiromao.restaurante.model.dto;

import br.com.guiromao.restaurante.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioOutputDto {
    private Integer id;
    private String nome;
    private String login;

    private List<String> roles = new ArrayList<>();

    private List<String> enderecos = new ArrayList<>();


    public UsuarioOutputDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.roles = usuario.getRoles().stream().map(role -> role.getLabel()).toList();
        this.enderecos =
                usuario.getEnderecos().stream().map(endereco -> endereco.getCep() + " - " + endereco.getRua()).toList();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public List<String> getRoles() {
        return roles;
    }

    public List<String> getEnderecos() {
        return enderecos;
    }
}
