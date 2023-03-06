package br.com.guiromao.restaurante.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private BigDecimal salario;

    public Funcionario() {}

    public Funcionario(String nome, String email, BigDecimal salario) {
        this.nome = nome;
        this.email = email;
        this.salario = salario;
    }

    public Integer getId() {return id;}

    public String getNome() {return nome;}

    public String getEmail() {return email;}

    public BigDecimal getSalario() {return salario;}
}
