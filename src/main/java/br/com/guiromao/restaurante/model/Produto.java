package br.com.guiromao.restaurante.model;

import java.math.BigDecimal;

public class Produto {

    private Integer id;
    private String nome;
    private String descricao;
    private Categoria categoria;
    private BigDecimal preco;

    public void setId(Integer id) { this.id = id; }

    public Integer getId() { return id; }

    public void setNome(String nome) { this.nome = nome; }

    public String getNome() { return nome; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getDescricao() { return descricao; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public Categoria getCategoria() { return categoria; }

    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public BigDecimal getPreco() { return preco; }
}
