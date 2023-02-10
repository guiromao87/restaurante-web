package br.com.guiromao.restaurante.model;

import java.math.BigDecimal;

public class ProdutoSimples {
    private Integer id;
    private String nome;
    private BigDecimal preco;

    public ProdutoSimples(Integer id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {return id;}

    public String getNome() {return nome;}

    public BigDecimal getPreco() {return preco;}

    public String toString() {
        return id + " - " + nome + " - " + preco;
    }
}
