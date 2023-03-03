package br.com.guiromao.restaurante.model.dto;

import br.com.guiromao.restaurante.model.Cliente;

public class ClienteInputDto {
    private String nome;
    private String email;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cliente toCliente() {
        return new Cliente(nome, email, senha);
    }
}
