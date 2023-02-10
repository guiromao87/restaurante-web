package br.com.guiromao.restaurante.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoSimples {
    private Integer id;
    private String nome;
    private BigDecimal preco;
    private boolean emEstoque;

    private LocalDate validade;

    public ProdutoSimples(Integer id, String nome, BigDecimal preco, boolean emEstoque, LocalDate validade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.emEstoque = emEstoque;
        this.validade = validade;
    }

    public Integer getId() {return id;}

    public String getNome() {return nome;}

    public BigDecimal getPreco() {return preco;}

    public boolean isEmEstoque() {return emEstoque;}

    public LocalDate getValidade() {return validade;}

    public String toString() {
        return id + " - " + nome + " - " + preco + " - " + emEstoque + " - " + validade;
    }
}
