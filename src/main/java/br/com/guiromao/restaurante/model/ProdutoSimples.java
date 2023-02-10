package br.com.guiromao.restaurante.model;

import java.math.BigDecimal;

public class ProdutoSimples {
    private Integer id;
    private String nome;
    private BigDecimal preco;
    private boolean emEstoque;

    public ProdutoSimples(Integer id, String nome, BigDecimal preco, boolean emEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.emEstoque = emEstoque;
    }

    public Integer getId() {return id;}

    public String getNome() {return nome;}

    public BigDecimal getPreco() {return preco;}

    public boolean isEmEstoque() {return emEstoque;}

    public String toString() {
        return id + " - " + nome + " - " + preco + " - " + emEstoque;
    }
}
