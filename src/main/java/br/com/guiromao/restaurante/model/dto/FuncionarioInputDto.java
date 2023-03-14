package br.com.guiromao.restaurante.model.dto;

import br.com.guiromao.restaurante.model.Funcionario;

import java.math.BigDecimal;

public class FuncionarioInputDto {
    private String nome;
    private String email;
    private BigDecimal salario;

    private Integer cargoId;

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

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Funcionario toFuncionario() {
        return new Funcionario(nome, email, salario);
    }

    public Integer getCargoId() {return cargoId;}

    public void setCargoId(Integer cargoId) {this.cargoId = cargoId;}
}
