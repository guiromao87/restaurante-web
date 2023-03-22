package br.com.guiromao.restaurante.model.dto;

import br.com.guiromao.restaurante.model.Endereco;
import br.com.guiromao.restaurante.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UsuarioInputDto {
    private String nome;
    private String login;
    private String senha;
    private List<Integer> roleIds = new ArrayList<>();
    private String cep;
    private String rua;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Usuario toUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome);
        usuario.setLogin(this.login);
        usuario.setSenha(new BCryptPasswordEncoder().encode(this.senha));

        return usuario;
    }

    public Endereco toEndereco() {
        Endereco endereco = new Endereco();
        endereco.setRua(this.rua);
        endereco.setCep(this.cep);

        return endereco;
    }
}
